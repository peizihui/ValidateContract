package io.hpb.result;

import io.hpb.web3.protocol.core.Response.Error;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class HpbResult<T> implements Serializable {

    private static final long serialVersionUID = -5548534177186829713L;
    /* 错误码 */
    private String status;
    /* 错误消息 */
    private String message;
    /* 具体内容 */
    private T data;

    public HpbResult(HpbResultCode resultCode) {
        this.status = resultCode.status();
        this.message = resultCode.message();
    }

    public HpbResult(HpbResultCode respCode, T data) {
        this(respCode);
        this.data = data;
    }


    public List<Object> SUCCESS() {
        this.status = HpbResultCode.SUCCESS.status();
        this.message = HpbResultCode.SUCCESS.message();
        return result(this.status, this.message, this.data);
    }

    public List<Object> FAIL() {
        this.status = HpbResultCode.FAIL.status();
        this.message = HpbResultCode.FAIL.message();
        return result(this.status, this.message, null);
    }

    public List<Object> error(Error error) {
        this.status = HpbResultCode.FAIL.status();
        this.message = error.getMessage();
        return result(this.status, this.message, null);
    }

    public List<Object> exception(Exception exception) {
        this.status = HpbResultCode.FAIL.status();
        this.message = HpbResultCode.ERROR_EXCEPTION.status();
        return result(this.status, this.message, null);
    }

    public List<Object> result(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        return Arrays.asList(this.status, this.message, this.data);
    }

    public List<Object> result(String status, String message) {
        return result(status, message, this.data);
    }

    public List<Object> getValue() {
        return result(this.status, this.message, this.data);
    }

}
