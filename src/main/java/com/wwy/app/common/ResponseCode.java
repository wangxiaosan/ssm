package com.wwy.app.common;

/**
 * Created by wangxiaosan on 17/1/10.
 */
public enum ResponseCode {
    /**
     * response status 200，请求正常
     */
    OK(200, "OK"), /**
     * response status 201
     */
    CREATED(201, "Created"), /**
     * response status 202
     */
    ACCEPTED(202, "Accepted"), /**
     * response status 204
     */
    NO_CONTENT(204, "No Content"), /**
     * response status 400
     */
    BAD_REQUEST(400, "Bad Request"), /**
     * response status 401
     */
    SC_UNAUTHORIZED(401, "Unauthorized Access"), /**
     * response status 403
     */
    FORBIDDEN(403, "Forbidden"), /**
     * response status 404
     */
    RESOURCE_NOT_FOUND(404, "Resource Not Found"), /**
     * response status 406
     */
    RESOURCE_NOT_ACCEPTABLE(406, "Resource Not Acceptable"), /**
     * response status 408
     */
    REQUEST_TIMEOUT(408, "Request Timeout"), /**
     * response status 500
     */
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"), /**
     * response status 201
     */
    SERVICE_UNAVAILABLE(503, "Service Unavailable"), /**
     * response status 510
     */
    DATA_ACCESS_ERROR(510, "Data Access Error"), /**
     * response status 512
     */
    NOT_SUPPORTED_ERROR(512, "Not supported Error"), /**
     * response status 550
     */
    BUSINESS_ERROR(550, "Business Error");

    private final int code;
    private final String reason;

    ResponseCode(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    public int code() {
        return code;
    }

    public String reason() {
        return reason;
    }
}
