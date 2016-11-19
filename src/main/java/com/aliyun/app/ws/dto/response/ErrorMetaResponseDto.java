package com.aliyun.app.ws.dto.response;

/**
 * Created by wangxiaosan on 16/11/18.
 */
public class ErrorMetaResponseDto {

    private String code;

    private String message;

    private String cause;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
