package com.wwy.app.model.dict;

/**
 * Created by wangxiaosan on 16/11/15.
 */
public enum ErrorCode {
    /**
     * 参数缺失
     */
    MissingParameter("MissingParameter"), /**
     * osType不合法
     */
    InvalidOSTypeMalformed("InvalidOSType.Malformed"), /**
     * 参数不合法
     */
    InvalidFormatMalformed("InvalidFormat.Malformed"), /**
     * windowsPatch不合法
     */
    InvalidWindowsPatchMalformed("InvalidWindowsPatch.Malformed"), /**
     * ossBucket没权限
     */
    OSSBucketForbidden("OSSBucket.Forbidden"), /**
     * ossBucket缺失
     */
    OSSBucketNotFound("OSSBucket.NotFound"), /**
     * taskId not found
     */
    InvalidTaskIdNotFound("InvalidTaskId.NotFound"), /**
     * sourceSystemOSSObject not found
     */
    SourceSystemOSSObjectNotFound("SourceSystemOSSObject.NotFound"), /**
     * scriptRelateFileOSSObject not found
     */
    ScriptRelateFileOSSObjectNotFound("ScriptRelateFileOSSObject.NotFound"), /**
     * architecture 不合法
     */
    InvalidArchitecture("InvalidArchitecture.Malformed"), /**
     * osLanguage不合法
     */
    InvalidOsLanguage("InvalidOsLanguage.Malformed"), /**
     * platform 不合法
     */
    InvalidPlatform("InvalidPlatform.Malformed"), /**
     * autoRepair不合法
     */
    InvalidAutoRepair("InvalidAutoRepair.Malformed"), /**
     * time格式不合法
     */
    InvalidUTCTime("InvalidUTCTime.Malformed"), /**
     * systemDiskSize不合法
     */
    InvalidSystemDiskSize("InvalidSystemDiskSize.Malformed"), /**
     * action 不合法
     */
    InvalidAction("InvalidAction.Malformed"), /**
     * configCheckItems 不合法
     */
    InvalidConfigCheckItems("InvalidConfigCheckItems.Malformed"), /**
     * callName已存在
     */
    ExistsCallName("CallName.Exists"), /**
     * 签名不合法
     */
    InvalidSign("InvalidSign.Malformed"), /**
     * 代码内部异常
     */
    InvalidCode("InvalidCode.Malformed"), /**
     * 操作异常
     */
    ErrorOperate("ErrorOperate.Malformed");
    private String value;

    ErrorCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
