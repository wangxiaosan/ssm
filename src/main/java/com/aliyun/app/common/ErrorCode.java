package com.aliyun.app.common;

/**
 * Created by wangxiaosan on 16/11/15.
 */
public enum ErrorCode {
    MissingParameter("MissingParameter"),InvalidOSTypeMalformed("InvalidOSType.Malformed"),
    InvalidFormatMalformed("InvalidFormat.Malformed"),InvalidWindowsPatchMalformed("InvalidWindowsPatch.Malformed"),
    OSSBucketForbbiden("OSSBucket.Forbbiden"),OSSBucketNotFound("OSSBucket.NotFound"),InvalidTaskIdNotFoun("InvalidTaskId.NotFoun"),
    SourceSystemOSSObjectNotFound("SourceSystemOSSObject.NotFound"),ScriptRelateFileOSSObjectNotFound("ScriptRelateFileOSSObject.NotFound");

    private String value;

    ErrorCode(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
