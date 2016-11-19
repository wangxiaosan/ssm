package com.aliyun.app.common;

/**
 * Created by wangxiaosan on 16/11/15.
 */
public enum ExceptionCode {

    BAD_REQUEST(400, "Bad Request");

    private final int code;
    private final String reason;

    private ExceptionCode(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    /**
     * Convert a numerical status code into the corresponding Status
     *
     * @param statusCode
     *            the numerical status code
     * @return the matching Status or null is no matching Status is defined
     */
    public static ExceptionCode fromStatusCode(final int statusCode) {
        for (ExceptionCode s : ExceptionCode.values()) {
            if (s.code == statusCode) {
                return s;
            }
        }
        return null;
    }
}
