package com.aliyun.app.common;

/**
 * Created by wangxiaosan on 16/11/15.
 */
public class Base400Exception extends RuntimeException {

    private final ExceptionCode code;

    private final String errorCode;

    public Base400Exception(String message, String errorCode) {
        super(message);
        this.code = ExceptionCode.BAD_REQUEST;
        this.errorCode = errorCode;
    }

    public Base400Exception(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.code = ExceptionCode.BAD_REQUEST;
        this.errorCode = errorCode;
    }

    public ExceptionCode getCode() {
        return code;
    }

    public String getErrorCode() {
        return errorCode;
    }

}
