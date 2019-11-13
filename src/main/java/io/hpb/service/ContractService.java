package io.hpb.service;

import com.github.pagehelper.PageInfo;
import io.hpb.contract.solidity.compiler.CompilationResult;
import io.hpb.entity.ContractEventInfo;
import io.hpb.entity.ContractInfo;
import io.hpb.entity.ContractMethodInfo;
import io.hpb.model.ContractInfoModel;
import io.hpb.model.ContractVerifyModel;
import io.hpb.result.Result;


import java.util.List;
import java.util.Map;

public interface ContractService {
    public Result<List<ContractEventInfo>> getContractEventInfoByEventHash(String eventHash);

    public Result<List<ContractEventInfo>> getContractEventInfoByContractAddr(String contractAddr);

    public Result<List<ContractMethodInfo>> getContractMethodInfoByContractAddr(String contractAddr);

    public Result<List<ContractMethodInfo>> getContractMethodInfoByMethodId(String methodId);

    public Result<ContractInfo> getContractInfoByContractAddr(String contractAddr);

    public Result<PageInfo<ContractInfo>> getContractInfoByName(String contractName, int pageNum, int pageSize);

    public Result<ContractInfo> validateContractInfo(String txHash, String contractAddr, String contractName, String contractSrc, String contractAbi,
                                                     String contractBin, String optimizeFlag, String contractCompilerType, String contractCompilerVersion);

  //  public boolean validateContract(ContractVerifyModel contractVerifyModel);

   // public Map validateContractByCompilerContractResult(ContractVerifyModel contractVerifyModel, CompilerContractResult compilerContractResult);

    public Map validateCompilerContractResult(ContractVerifyModel contractVerifyModel, CompilationResult compilerContractResult);



    public String getContractAddress(String txHash);

    public PageInfo<ContractInfo> queryPageContractInfoList(ContractInfoModel model);

    public boolean checkIsValidated(String contractAddress);

    public ContractInfo getContractInfoByContractAddrs(String contractAddr);

    void  compileSrc();
}
