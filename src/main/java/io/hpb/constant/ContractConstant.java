package io.hpb.constant;

/**
 * @author ThinkPad
 * 这里全部声明常量
 */
public interface ContractConstant {
    public static final String EVENT_HASH = "eventHash";
    public static final String CONTRACT_NAME = "contractName";
    public static final String CONTRACT_ADDR = "contractAddr";
    public static final String CONTRACT_COMPILER_TYPE = "compilerType";
    public static final String CONTRACT_COMPILER_VERSION = "compilerVersion";

    public static final String METHOD_ID = "methodId";
    public static final String TX_HASH = "txHash";
    public static final String CONTRACT_SRC = "contractSrc";
    public static final String CONTRACT_ABI = "contractAbi";
    public static final String CONTRACT_BIN = "contractBin";
    public static final String OPTIMIZE_FLAG = "optimizeFlag";
    public static final String CONTRACT_LIBRARY_NAME_ADDRESS_LIST = "contractLibraryNameAddressList";

    public static final String RETURN_CODE = "RETURN_CODE";
    public static final String RETURN_MSG = "RETURN_MSG";
    public static final String SUCCESS_CODE = "000000";
    public static final String ERROR_CODE = "999999";
    public static final String ERROR_CODE_VALIED_FAIL = "000001";
    public static final String ERROR_CODE_HAVE_VALIED = "000002";
    public static final String SUCCESS_MSG = "操作成功";
    public static final String NOSRCCODE = "请指定需要编译的solidity代码";
    public static final String NO_HASH = "请输入创建该合约的交易Hash";
    public static final String HAVE_VALIED = "已经验证过";
    public static final String HAVE_NOT_VALIED = "验证失败";
    public static final String PROCCESS_ID = "proccessId";
   // public static final String SOLC_CMD_DEFAULT = "docker rm -rf solc;docker run -it --privileged=true --net=host -v /home/hpbroot/ethereum_go/contract:/contract --name solc ethereum/solc:stable";
    public static final String SOLC_STABLE="stable";
    public static final String SOLC_CMD_DEFAULT="docker run --rm -it --privileged=true --name solc ethereum/solc";

/*    public static final String RETURN_CODE="RETURN_CODE";
    public static final String RETURN_MSG="RETURN_MSG";
    public static final String SUCCESS_CODE="000000";
    public static final String ERROR_CODE="999999";
    public static final String SUCCESS_MSG = "操作成功";
    public static final String NOSRCCODE = "请指定需要编译的solidity代码";
    public static final String PROCCESS_ID = "proccessId";
    public static final String SOLC_CMD_DEFAULT="docker run --rm -it --privileged=true --name solc ethereum/solc";
    public static final String SOLC_STABLE="stable";*/
}
