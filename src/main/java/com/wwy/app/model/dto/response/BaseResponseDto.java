package com.wwy.app.model.dto.response;

import java.io.Serializable;

/**
 * Created by wangxiaosan on 16/11/10.
 */
public class BaseResponseDto implements Serializable {
    private String requestId;//UUID生成的唯一标识
    private Boolean success;//是否成功
    private String code;//返回结果编码
    private String message;//返回结果编码描述

    public BaseResponseDto(){

    }

    public BaseResponseDto(String requestId,Boolean success,String code,String message){
        this.requestId = requestId;
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

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
}
