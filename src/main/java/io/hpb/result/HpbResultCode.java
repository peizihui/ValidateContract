package io.hpb.result;

public enum HpbResultCode {
    /**
     * 成功
     */
    SUCCESS("0000", "成功"),
    /**
     * 失败
     */
    FAIL("999999", "失败"),

    /**
     * 网络异常，请稍后重试
     */
    WARN("-1", "网络异常，请稍后重试"),

    /**
     * 没有登录
     */
    NOT_LOGIN("400", "没有登录"),

    /**
     * 发生异常
     */
    EXCEPTION("401", "发生异常"),

    /**
     * 发生异常
     */
    ERROR_EXCEPTION("40101", "获取区块链信息异常"),

    /**
     * 系统错误
     */
    SYS_ERROR("402", "系统错误"),

    /**
     * 参数错误
     */
    PARAMS_ERROR("403", "参数错误 "),

    /**
     * 响应结果为空
     */
    RESPONSE_EMPTY("404", "响应结果为空"),

    /**
     * 响应结果为空
     */
    RESPONSE_NULL("404", "响应结果为空"),

    /**
     * 不支持或已经废弃
     */
    NOT_SUPPORTED("410", "不支持或已经废弃"),

    /**
     * AuthCode错误
     */
    INVALID_AUTHCODE("444", "无效的AuthCode"),

    /**
     * 太频繁的调用
     */
    TOO_FREQUENT("445", "太频繁的调用"),

    /**
     * 未知的错误
     */
    UNKNOWN_ERROR("499", "未知错误"),

    /**
     * 不合法 钱包地址
     */
    INVALID_ADDRESS("10104", "不合法 钱包地址"),

    /**
     * 不合法 交易HASH
     */
    INVALID_TXHASH("10105", "不合法 交易HASH"),

    /**
     * 不合法 区块HASH
     */
    INVALID_BLOCKHASH("10106", "不合法 区块HASH"),

    /**
     * 参数错误
     */
    PARAMETER_ERROR("10101", "参数错误");


    private HpbResultCode(String message, String status) {
        this.status = status;
        this.message = message;
    }

    public String status() {
        return status;
    }

    public String message() {
        return message;
    }

    private String status;
    private String message;
}
