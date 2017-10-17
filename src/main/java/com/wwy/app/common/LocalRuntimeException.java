package com.wwy.app.common;

/**
 * Created by wangxiaosan on 17/1/10.
 */
public class LocalRuntimeException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 4395547434330678738L;

    private final ResponseCode code;

    private final String errorCode;

    public LocalRuntimeException(String message, ResponseCode code, String errorCode) {
        super(message);
        this.code = code;
        this.errorCode = errorCode;
    }

    public ResponseCode getCode() {
        return code;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
