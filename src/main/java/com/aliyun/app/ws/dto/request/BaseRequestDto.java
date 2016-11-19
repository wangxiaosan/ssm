package com.aliyun.app.ws.dto.request;

import java.io.Serializable;

/**
 * Created by wangxiaosan on 16/11/10.
 */
public class BaseRequestDto implements Serializable {

    private String key;//标识用户唯一性的key
    private String sign;//签名字符串，生成算法可以使用对称加密
    private String timeStamp;//请求的时间戳。日期格式按照iso8601标准表示，并需要使用utc时间。格式为：YYYY－MM－DDThh:mm:ssZ
    private String requestId;//UUID用于trace
    private String clientToken;//用于保证请求的幂等性。由客户端生成该参数值，保证唯一。最大不超过64个ASCII字符

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getClientToken() {
        return clientToken;
    }

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }
}
