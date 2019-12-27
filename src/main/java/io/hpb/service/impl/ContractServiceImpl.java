package io.hpb.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.hpb.configure.ContractConfig;
import io.hpb.configure.HpbContractValidateProperties;
import io.hpb.constant.BcConstant;
import io.hpb.contract.controller.HpbController;
import io.hpb.contract.solidity.compiler.CompilationResult;
import io.hpb.entity.*;
import io.hpb.example.ContractEventInfoExample;
import io.hpb.example.ContractInfoExample;
import io.hpb.example.ContractMethodInfoExample;
import io.hpb.mapper.*;
import io.hpb.model.ContractInfoModel;
import io.hpb.model.ContractVerifyModel;
import io.hpb.result.Result;
import io.hpb.result.ResultCode;
import io.hpb.service.AbstractBaseService;
import io.hpb.service.ContractService;
import io.hpb.util.DateUtils;
import io.hpb.util.UUIDGeneratorUtil;
import io.hpb.web3.crypto.Hash;
import io.hpb.web3.crypto.WalletUtils;
import io.hpb.web3.protocol.ObjectMapperFactory;
import io.hpb.web3.protocol.admin.Admin;
import io.hpb.web3.protocol.core.methods.response.AbiDefinition;
import io.hpb.web3.protocol.core.methods.response.AbiDefinition.NamedType;
import io.hpb.web3.protocol.core.methods.response.HpbTransaction;
import io.hpb.web3.protocol.core.methods.response.Transaction;
import io.hpb.web3.protocol.core.methods.response.TransactionReceipt;
import io.hpb.web3.utils.Numeric;
import io.hpb.web3.utils.ObjectJsonHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

@Service
public class ContractServiceImpl extends AbstractBaseService implements ContractService {
    private static final String FUNCTION = "function";
    private static final String EVENT = "event";
    private static final String COMMA = ",";
    private static final String ONE_BLANK = " ";
    private static final String LEFT_BRACKET = "(";
    private static final String RIGHT_BRACKET = ")";
    public Logger log = LoggerFactory.getLogger(ContractServiceImpl.class);
    @Autowired
    ContractLibraryAddressInfoMapper contractLibraryAddressInfoMapper;
   // @Autowired
    //AsyncErc20Task asyncErc20Task;
    @Autowired
    private Admin admin;
    @Autowired
    private ContractEventInfoMapper contractEventInfoMapper;
    @Autowired
    private ContractInfoMapper contractInfoMapper;
    @Autowired
    private ContractMethodInfoMapper contractMethodInfoMapper;
    @Autowired
    private ContractConfig contractConfig;

    @Autowired
    HpbContractValidateProperties hpbContractValidateProperties;
    @Autowired
    private ContractErcStandardInfoMapper contractErcStandardInfoMapper;

    @Override
    public Result<List<ContractEventInfo>> getContractEventInfoByEventHash(String eventHash) {
        if (StringUtils.isBlank(eventHash) || eventHash.length() != 66) {
            return new Result<List<ContractEventInfo>>(ResultCode.SUCCESS);
        }
        ContractEventInfoExample contractEventInfoExample = new ContractEventInfoExample();
        contractEventInfoExample.createCriteria().andEventHashEqualTo(eventHash);
        List<ContractEventInfo> list = contractEventInfoMapper.selectByExample(contractEventInfoExample);
        return new Result<List<ContractEventInfo>>(ResultCode.SUCCESS, list);
    }

    @Override
    public Result<List<ContractEventInfo>> getContractEventInfoByContractAddr(String contractAddr) {
        if (!WalletUtils.isValidAddress(contractAddr)) {
            return new Result<List<ContractEventInfo>>(ResultCode.SUCCESS);
        }
        ContractEventInfoExample contractEventInfoExample = new ContractEventInfoExample();
        contractEventInfoExample.createCriteria().andContractAddrEqualTo(contractAddr);
        List<ContractEventInfo> list = contractEventInfoMapper.selectByExample(contractEventInfoExample);
        return new Result<List<ContractEventInfo>>(ResultCode.SUCCESS, list);
    }

    @Override
    public Result<List<ContractMethodInfo>> getContractMethodInfoByContractAddr(String contractAddr) {
        if (!WalletUtils.isValidAddress(contractAddr)) {
            return new Result<List<ContractMethodInfo>>(ResultCode.SUCCESS);
        }
        ContractMethodInfoExample contractMethodInfoExample = new ContractMethodInfoExample();
        contractMethodInfoExample.createCriteria().andContractAddrEqualTo(contractAddr);
        List<ContractMethodInfo> list = contractMethodInfoMapper.selectByExample(contractMethodInfoExample);
        return new Result<List<ContractMethodInfo>>(ResultCode.SUCCESS, list);
    }

    @Override
    public Result<List<ContractMethodInfo>> getContractMethodInfoByMethodId(String methodId) {
        if (StringUtils.isBlank(methodId) || methodId.length() != 10) {
            return new Result<List<ContractMethodInfo>>(ResultCode.SUCCESS);
        }
        ContractMethodInfoExample contractMethodInfoExample = new ContractMethodInfoExample();
        contractMethodInfoExample.createCriteria().andMethodIdEqualTo(methodId);
        List<ContractMethodInfo> list = contractMethodInfoMapper.selectByExample(contractMethodInfoExample);
        return new Result<List<ContractMethodInfo>>(ResultCode.SUCCESS, list);
    }

    @Override
    public Result<PageInfo<ContractInfo>> getContractInfoByName(String contractName, int pageNum, int pageSize) {
        if (StringUtils.isBlank(contractName)) {
            return new Result<PageInfo<ContractInfo>>(ResultCode.SUCCESS);
        }
        PageHelper.startPage(pageNum, pageSize);
        ContractInfoExample contractInfoExample = new ContractInfoExample();
        contractInfoExample.createCriteria().andContractNameEqualTo(contractName);
        contractInfoExample.setOrderByClause("contract_name desc");
        List<ContractInfo> list = contractInfoMapper.selectByExample(contractInfoExample);
        PageInfo<ContractInfo> pageInfo = new PageInfo<ContractInfo>(list);
        return new Result<PageInfo<ContractInfo>>(ResultCode.SUCCESS, pageInfo);
    }

    @Override
    public Result<ContractInfo> getContractInfoByContractAddr(String contractAddr) {
        if (!WalletUtils.isValidAddress(contractAddr)) {
            return new Result<ContractInfo>(ResultCode.SUCCESS);
        }
        ContractInfo contractInfo = contractInfoMapper.selectByPrimaryKey(contractAddr);

        //todo 获取到合约创建inputData 放在详情接口里,这里暂时不想删除
        //1. 从contract_erc_standard_info表查询到deployHash
        ContractErcStandardInfo standardInfo = contractErcStandardInfoMapper.selectByContractAddress(contractAddr);
        if (standardInfo != null) {
            String deployTxHash = standardInfo.getDeployTxHash();
            try {
                HpbTransaction hpbTransaction = admin.hpbGetTransactionByHash(deployTxHash).sendAsync().get(2, TimeUnit.MINUTES);
                Transaction transaction = hpbTransaction.getResult();
                String input = transaction.getInput();
                contractInfo.setContractCreater(input.startsWith("0x") ? Numeric.cleanHexPrefix(input) : input);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return new Result<ContractInfo>(ResultCode.SUCCESS, contractInfo);
    }

    @Override
    public Result<ContractInfo> validateContractInfo(String txHash, String contractAddr, String contractName,
                                                     String contractSrc, String contractAbi, String contractBin, String optimizeFlag, String contractCompilerType, String contractCompilerVersion) {
        try {
            HpbTransaction hpbTransaction = admin.hpbGetTransactionByHash(txHash).sendAsync().
                    get(BcConstant.WEB3J_TIMEOUT, TimeUnit.MINUTES);
            Transaction transaction = hpbTransaction.getResult();
            ContractInfo contractInfo = new ContractInfo();
            if (transaction != null && contractAddr.equals(transaction.getTo())) {
                String input = transaction.getInput();
                if (contractAbi.equals(input)) {
                    String contractCreater = transaction.getFrom();
                    contractInfo.setContractName(contractName);
                    contractInfo.setContractCreater(contractCreater);
                    contractInfo.setContractSrc(contractSrc);
                    contractInfo.setContractAbi(contractAbi);
                    contractInfo.setContractBin(contractBin);
                    contractInfo.setOptimizeFlag(optimizeFlag);
                    contractInfo.setCompilerType(contractCompilerType);
                    contractInfo.setCompilerVersion(contractCompilerVersion);
                    contractInfoMapper.insert(contractInfo);

                    ObjectMapper objectMapper = ObjectMapperFactory.getObjectMapper();
                    AbiDefinition[] abiDefinition = objectMapper.readValue(contractAbi, AbiDefinition[].class);
                    List<AbiDefinition> abiDefinitionList = Arrays.asList(abiDefinition);
                    abiDefinitionList.forEach(obj -> {
                        if (FUNCTION.equals(obj.getType())) {
                            String name = obj.getName();
                            List<NamedType> parameters = obj.getInputs();
                            StringBuilder methodBody = new StringBuilder();
                            StringBuilder methodName = new StringBuilder();
                            methodBody.append(name);
                            methodBody.append(LEFT_BRACKET);
                            String params = parameters.stream().map(NamedType::getType).collect(Collectors.joining(COMMA));
                            methodBody.append(params);
                            methodBody.append(RIGHT_BRACKET);

                            methodName.append(name);
                            methodName.append(LEFT_BRACKET);
                            String ps = parameters.stream().map(x -> x.getType() + ONE_BLANK + x.getName())
                                    .collect(Collectors.joining(COMMA));
                            methodName.append(ps);
                            methodName.append(RIGHT_BRACKET);
                            String methodId = buildMethodId(methodBody.toString());
                            ContractMethodInfo contractMethodInfo = new ContractMethodInfo();
                            contractMethodInfo.setContractAddr(contractAddr);
                            contractMethodInfo.setId(UUIDGeneratorUtil.generate(obj));
                            contractMethodInfo.setMethodId(methodId);
                            contractMethodInfo.setMethodName(methodName.toString());
                            contractMethodInfoMapper.insert(contractMethodInfo);
                        }
                        if (EVENT.equals(obj.getType())) {
                            String name = obj.getName();
                            List<NamedType> parameters = obj.getInputs();
                            StringBuilder methodBody = new StringBuilder();
                            StringBuilder eventName = new StringBuilder();
                            methodBody.append(name);
                            methodBody.append(LEFT_BRACKET);
                            String params = parameters.stream().map(NamedType::getType).collect(Collectors.joining(COMMA));
                            methodBody.append(params);
                            methodBody.append(RIGHT_BRACKET);

                            eventName.append(name);
                            eventName.append(LEFT_BRACKET);
                            String ps = parameters.stream().map(x -> x.getType() + ONE_BLANK + x.getName())
                                    .collect(Collectors.joining(COMMA));
                            eventName.append(ps);
                            eventName.append(RIGHT_BRACKET);
                            String eventHash = buildEventSignature(methodBody.toString());
                            ContractEventInfo contractEventInfo = new ContractEventInfo();
                            contractEventInfo.setContractAddr(contractAddr);
                            contractEventInfo.setId(UUIDGeneratorUtil.generate(obj));
                            contractEventInfo.setEventName(eventName.toString());
                            contractEventInfo.setEventHash(eventHash);
                            contractEventInfoMapper.insert(contractEventInfo);
                        }
                    });
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return null;
    }

    private String buildMethodId(String methodBody) {
        byte[] input = methodBody.getBytes();
        byte[] hash = Hash.sha3(input);
        return Numeric.toHexString(hash).substring(0, 10);
    }

    private String buildEventSignature(String methodBody) {
        byte[] input = methodBody.getBytes();
        byte[] hash = Hash.sha3(input);
        return Numeric.toHexString(hash);
    }

    @Override
    public Map validateCompilerContractResult(ContractVerifyModel contractVerifyModel, CompilationResult compilerContractResult,String compileAbi,String compileBin) {

        log.info("validateContractByCompilerContractResult address [{}] ,", contractVerifyModel.getContractAddr());
        log.info("compileAbi ==="+compileAbi);
        log.info("compileBin ==="+compileBin);
        Map resultMap = new HashMap();
        String txHash = contractVerifyModel.getTxHash();
        String contractAddr = contractVerifyModel.getContractAddr();
        String contractSrc = contractVerifyModel.getContractSrc();
        String contractCompilerType = contractVerifyModel.getContractCompilerType();
        String contractCompilerVersion = contractVerifyModel.getContractCompilerVersion();
        String contractName = contractVerifyModel.getContractName();
        //String contractAbi = compileAbi;
        // String contractBin = compileBin;
        String optimizeFlag = contractVerifyModel.getOptimizeFlag();
        String hvmVersion = contractVerifyModel.getHvmVersion();
        Long miscSettingRuns = contractVerifyModel.getMiscSettingRuns();
        List<ContractLibraryAddressInfo> contractLibraryAddressInfoList = contractVerifyModel.getContractLibraryAddressInfoList();
        if (CollectionUtils.isNotEmpty(contractLibraryAddressInfoList)) {
            for (ContractLibraryAddressInfo info : contractLibraryAddressInfoList) {
                info.setCreateTimestamp(DateUtils.getNowDate());
                info.setContractAddress(contractAddr);
                log.info("contractLibraryAddressInfoMapper.insert contractAddr " + contractAddr);
                contractLibraryAddressInfoMapper.insert(info);
            }
        }

        boolean flag = false;
        HpbTransaction hpbTransaction = null;
        Transaction transaction = null;
        try {
            hpbTransaction = admin.hpbGetTransactionByHash(txHash).sendAsync().get(BcConstant.WEB3J_TIMEOUT, TimeUnit.MINUTES);
            transaction = hpbTransaction.getResult();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        // toAddress 为空；明天调整  && contractAddr.equals(transaction.getTo()) ；
        if (transaction != null) {
            try {
                Optional<TransactionReceipt> txReceiptOptional = admin.hpbGetTransactionReceipt(hpbTransaction.getTransaction().get().getHash()).sendAsync().get(BcConstant.WEB3J_TIMEOUT, TimeUnit.MINUTES).getTransactionReceipt();
                if (txReceiptOptional.isPresent()) {
                    TransactionReceipt transactionReceipt = txReceiptOptional.get();
                    transactionReceipt.getContractAddress();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
        String input = transaction.getInput();
        try {
            if (StringUtils.isNotEmpty(input)) {
                String from = "";
                if (transaction != null) {
                    from = transaction.getFrom();
                }
                String contractCreater = from;
                ContractInfo contractInfo = new ContractInfo();
                contractInfo.setContractName(contractName);
                contractInfo.setContractCreater(contractCreater);
                contractInfo.setContractSrc(contractSrc);
                contractInfo.setContractAbi(compileAbi);
                contractInfo.setContractBin(compileBin);
                contractInfo.setOptimizeFlag(optimizeFlag);
                contractInfo.setCompilerType(contractCompilerType);
                contractInfo.setCompilerVersion(contractCompilerVersion);
                contractInfo.setContractAddr(contractAddr);
                contractInfo.setHvmVersion(hvmVersion);
                contractInfo.setMiscSettingRuns(miscSettingRuns);
                contractInfo.setCreateTimestamp(DateUtils.getNowDate());
                contractInfo.setVerifiedStatus("Y");
                contractInfo.setVerifiedTimestamp(DateUtils.getNowDate());
                ContractInfo contractInfoInDb = contractInfoMapper.selectByPrimaryKey(contractAddr);
                flag = true;
               // resultMap.put("isValidate", flag);
                if (contractInfoInDb != null) {
                    contractInfoMapper.updateByPrimaryKey(contractInfo);
                } else {
                    int x = contractInfoMapper.insert(contractInfo);
                    log.info("  contractInfoMapper.insert(contractInfo) x ===="+x);
                }
                ObjectMapper objectMapper = ObjectMapperFactory.getObjectMapper();
                AbiDefinition[] abiDefinition = objectMapper.readValue(compileAbi, AbiDefinition[].class);
                List<AbiDefinition> abiDefinitionList = Arrays.asList(abiDefinition);
                abiDefinitionList.forEach(obj -> {
                    String abi = null;
                    try {
                        abi = ObjectJsonHelper.serialize(obj);
                        log.info("AbiDefinition abi ==="+abi);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    if (FUNCTION.equals(obj.getType())) {
                        String name = obj.getName();
                        List<NamedType> parameters = obj.getInputs();
                        StringBuilder methodBody = new StringBuilder();
                        StringBuilder methodName = new StringBuilder();
                        methodBody.append(name);
                        methodBody.append(LEFT_BRACKET);
                        String params = parameters.stream().map(NamedType::getType).collect(Collectors.joining(COMMA));
                        methodBody.append(params);
                        methodBody.append(RIGHT_BRACKET);

                        methodName.append(name);
                        methodName.append(LEFT_BRACKET);
                        String ps = parameters.stream().map(x -> x.getType() + ONE_BLANK + x.getName())
                                .collect(Collectors.joining(COMMA));
                        methodName.append(ps);
                        methodName.append(RIGHT_BRACKET);
                        String methodId = buildMethodId(methodBody.toString());
                        ContractMethodInfo contractMethodInfo = new ContractMethodInfo();
                        contractMethodInfo.setContractAddr(contractAddr);
                        contractMethodInfo.setId(UUIDGeneratorUtil.generate(obj));
                        contractMethodInfo.setMethodId(methodId);
                        contractMethodInfo.setMethodName(methodName.toString());
                        contractMethodInfo.setMethodAbi(abi);
                        contractMethodInfo.setCreateTimestamp(DateUtils.getNowDate());
                        ContractMethodInfo contractMethodInfoInDb = contractMethodInfoMapper.selectByContractAndMethod(contractAddr,methodId);
                        if(contractMethodInfoInDb == null){
                            int cm =  contractMethodInfoMapper.insert(contractMethodInfo);
                            log.info("  contractMethodInfoMapper.insert(contractMethodInfo) cm ===="+cm);
                        }

                    }
                    if (EVENT.equals(obj.getType())) {
                        String name = obj.getName();
                        List<NamedType> parameters = obj.getInputs();
                        StringBuilder methodBody = new StringBuilder();
                        StringBuilder eventName = new StringBuilder();
                        methodBody.append(name);
                        methodBody.append(LEFT_BRACKET);
                        String params = parameters.stream().map(NamedType::getType).collect(Collectors.joining(COMMA));
                        methodBody.append(params);
                        methodBody.append(RIGHT_BRACKET);

                        eventName.append(name);
                        eventName.append(LEFT_BRACKET);
                        String ps = parameters.stream().map(x -> x.getType() + ONE_BLANK + x.getName())
                                .collect(Collectors.joining(COMMA));
                        eventName.append(ps);
                        eventName.append(RIGHT_BRACKET);
                        String eventHash = buildEventSignature(methodBody.toString());
                        ContractEventInfo contractEventInfo = new ContractEventInfo();
                        contractEventInfo.setContractAddr(contractAddr);
                        contractEventInfo.setEventAbi(abi);
                        contractEventInfo.setId(UUIDGeneratorUtil.generate(obj));
                        contractEventInfo.setEventName(eventName.toString());
                        contractEventInfo.setEventHash(eventHash);
                        contractEventInfo.setCreateTimestamp(DateUtils.getNowDate());
                        ContractEventInfo contractEventInfoInDb =   contractEventInfoMapper.selectByContractEventInfo(contractAddr,eventHash);
                        if(contractEventInfoInDb == null){
                            int cei =  contractEventInfoMapper.insert(contractEventInfo);
                            log.info("  contractEventInfoMapper.insert(contractEventInfo) cei ===="+cei);
                        }
                    }
                });
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return resultMap;
    }

    @Override
    public String getContractAddress(String txHash) {
        try {
            HpbTransaction hpbTransaction = admin.hpbGetTransactionByHash(txHash).sendAsync().get(BcConstant.WEB3J_TIMEOUT, TimeUnit.MINUTES);
            Transaction transaction = hpbTransaction.getResult();
            // toAddress 为空；明天调整  && contractAddr.equals(transaction.getTo()) ；
            if (transaction != null) {
                Optional<TransactionReceipt> txReceiptOptional = admin.hpbGetTransactionReceipt(hpbTransaction.getTransaction().get().getHash()).sendAsync().get(BcConstant.WEB3J_TIMEOUT, TimeUnit.MINUTES).getTransactionReceipt();

                if (txReceiptOptional.isPresent()) {
                    TransactionReceipt transactionReceipt = txReceiptOptional.get();
                    return transactionReceipt.getContractAddress();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PageInfo<ContractInfo> queryPageContractInfoList(ContractInfoModel model) {
        PageHelper.startPage(model.getCurrentPage(), model.getPageSize());
        ContractInfoExample contractInfoExample = new ContractInfoExample();
        ContractInfoExample.Criteria criteria = contractInfoExample.createCriteria();
        if (StringUtils.isNotEmpty(model.getContractAddr())) {
            criteria.andContractAddrEqualTo(model.getContractAddr());
        }

        if (StringUtils.isNotEmpty(model.getContractName())) {
            criteria.andContractNameEqualTo(model.getContractName());
        }

        contractInfoExample.setOrderByClause(" contract_name desc");
        List<ContractInfo> list = contractInfoMapper.selectByExample(contractInfoExample);
        PageInfo<ContractInfo> pageInfo = new PageInfo<ContractInfo>(list);
        List<ContractInfo> contractInfoList = pageInfo.getList();
        List<ContractInfo> resultContractInfoList = Collections.synchronizedList(new ArrayList<ContractInfo>());
        try {
            CountDownLatch countDownLatch = new CountDownLatch(contractInfoList.size());
            for (ContractInfo contractInfo : contractInfoList) {
                //asyncErc20Task.getBalanceByAddress(countDownLatch, contractInfo, resultContractInfoList);
            }
            countDownLatch.await(2, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pageInfo;
    }


    @Override
    public boolean checkIsValidated(String contractAddress) {

        ContractInfo contractInfo = contractInfoMapper.selectByPrimaryKey(contractAddress);
        if (contractInfo != null && contractInfo.getVerifiedStatus().equals("Y")) {
            return true;
        }
        return false;
    }




    @Override
    public ContractInfo getContractInfoByContractAddrs(String contractAddr) {
        return contractInfoMapper.selectByPrimaryKey(contractAddr);
    }

    @Override
    public void compileSrc() {

    }
}