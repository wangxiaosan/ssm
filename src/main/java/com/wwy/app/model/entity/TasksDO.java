package com.wwy.app.model.entity;

import java.util.Date;

public class TasksDO {
    private Integer id;

    private Date gmtModify;

    private Date gmtCreate;

    private String appKey;

    private String appSecret;

    private String sign;

    private String requestId;

    private String clientToken;

    private String regionId;

    private String imageId;

    private String taskType;

    private String osType;

    private String language;

    private String architecture;

    private String platform;

    private String version;

    private Boolean isMakeDone;

    private Long systemDiskSize;

    private String storageType;

    private String storageUrl;

    private String storageChecksum;

    private String storageChecksumType;

    private String ossBucket;

    private String userDefinedScriptUrl;

    private String scriptRelatedFileUrl;

    private Boolean isAutoRepair;

    private Boolean isInstallWindowsUpdate;

    private String targetImageFormat;

    private String systemDiskFormat;

    private String disabledCheckItems;

    private String disabledFixItems;

    private Integer checkTimeout;

    private Integer makeTimeout;

    private Boolean isImgReady;

    private Boolean isXenDownloadImgOk;

    private String taskId;

    private String resultImageOssBucket;

    private String resultImageOssObject;

    private Boolean isSupportCancel;

    private Long startTime;

    private String progress;

    private Long expectedTime;

    private Long finishedTime;

    private String status;

    private String nodeId;

    private Boolean isKvmEnabled;

    private Boolean isKvmDone;

    private String kvmNcIp;

    private Boolean isXenEnabled;

    private Boolean isXenDone;

    private String xenNcIp;

    private String errorMsg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
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

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Boolean getIsMakeDone() {
        return isMakeDone;
    }

    public void setIsMakeDone(Boolean isMakeDone) {
        this.isMakeDone = isMakeDone;
    }

    public Long getSystemDiskSize() {
        return systemDiskSize;
    }

    public void setSystemDiskSize(Long systemDiskSize) {
        this.systemDiskSize = systemDiskSize;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getStorageUrl() {
        return storageUrl;
    }

    public void setStorageUrl(String storageUrl) {
        this.storageUrl = storageUrl;
    }

    public String getStorageChecksum() {
        return storageChecksum;
    }

    public void setStorageChecksum(String storageChecksum) {
        this.storageChecksum = storageChecksum;
    }

    public String getStorageChecksumType() {
        return storageChecksumType;
    }

    public void setStorageChecksumType(String storageChecksumType) {
        this.storageChecksumType = storageChecksumType;
    }

    public String getOssBucket() {
        return ossBucket;
    }

    public void setOssBucket(String ossBucket) {
        this.ossBucket = ossBucket;
    }

    public String getUserDefinedScriptUrl() {
        return userDefinedScriptUrl;
    }

    public void setUserDefinedScriptUrl(String userDefinedScriptUrl) {
        this.userDefinedScriptUrl = userDefinedScriptUrl;
    }

    public String getScriptRelatedFileUrl() {
        return scriptRelatedFileUrl;
    }

    public void setScriptRelatedFileUrl(String scriptRelatedFileUrl) {
        this.scriptRelatedFileUrl = scriptRelatedFileUrl;
    }

    public Boolean getIsAutoRepair() {
        return isAutoRepair;
    }

    public void setIsAutoRepair(Boolean isAutoRepair) {
        this.isAutoRepair = isAutoRepair;
    }

    public Boolean getIsInstallWindowsUpdate() {
        return isInstallWindowsUpdate;
    }

    public void setIsInstallWindowsUpdate(Boolean isInstallWindowsUpdate) {
        this.isInstallWindowsUpdate = isInstallWindowsUpdate;
    }

    public String getTargetImageFormat() {
        return targetImageFormat;
    }

    public void setTargetImageFormat(String targetImageFormat) {
        this.targetImageFormat = targetImageFormat;
    }

    public String getSystemDiskFormat() {
        return systemDiskFormat;
    }

    public void setSystemDiskFormat(String systemDiskFormat) {
        this.systemDiskFormat = systemDiskFormat;
    }

    public String getDisabledCheckItems() {
        return disabledCheckItems;
    }

    public void setDisabledCheckItems(String disabledCheckItems) {
        this.disabledCheckItems = disabledCheckItems;
    }

    public String getDisabledFixItems() {
        return disabledFixItems;
    }

    public void setDisabledFixItems(String disabledFixItems) {
        this.disabledFixItems = disabledFixItems;
    }

    public Integer getCheckTimeout() {
        return checkTimeout;
    }

    public void setCheckTimeout(Integer checkTimeout) {
        this.checkTimeout = checkTimeout;
    }

    public Integer getMakeTimeout() {
        return makeTimeout;
    }

    public void setMakeTimeout(Integer makeTimeout) {
        this.makeTimeout = makeTimeout;
    }

    public Boolean getIsImgReady() {
        return isImgReady;
    }

    public void setIsImgReady(Boolean isImgReady) {
        this.isImgReady = isImgReady;
    }

    public Boolean getIsXenDownloadImgOk() {
        return isXenDownloadImgOk;
    }

    public void setIsXenDownloadImgOk(Boolean isXenDownloadImgOk) {
        this.isXenDownloadImgOk = isXenDownloadImgOk;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getResultImageOssBucket() {
        return resultImageOssBucket;
    }

    public void setResultImageOssBucket(String resultImageOssBucket) {
        this.resultImageOssBucket = resultImageOssBucket;
    }

    public String getResultImageOssObject() {
        return resultImageOssObject;
    }

    public void setResultImageOssObject(String resultImageOssObject) {
        this.resultImageOssObject = resultImageOssObject;
    }

    public Boolean getIsSupportCancel() {
        return isSupportCancel;
    }

    public void setIsSupportCancel(Boolean isSupportCancel) {
        this.isSupportCancel = isSupportCancel;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public Long getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Long expectedTime) {
        this.expectedTime = expectedTime;
    }

    public Long getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Long finishedTime) {
        this.finishedTime = finishedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Boolean getIsKvmEnabled() {
        return isKvmEnabled;
    }

    public void setIsKvmEnabled(Boolean isKvmEnabled) {
        this.isKvmEnabled = isKvmEnabled;
    }

    public Boolean getIsKvmDone() {
        return isKvmDone;
    }

    public void setIsKvmDone(Boolean isKvmDone) {
        this.isKvmDone = isKvmDone;
    }

    public String getKvmNcIp() {
        return kvmNcIp;
    }

    public void setKvmNcIp(String kvmNcIp) {
        this.kvmNcIp = kvmNcIp;
    }

    public Boolean getIsXenEnabled() {
        return isXenEnabled;
    }

    public void setIsXenEnabled(Boolean isXenEnabled) {
        this.isXenEnabled = isXenEnabled;
    }

    public Boolean getIsXenDone() {
        return isXenDone;
    }

    public void setIsXenDone(Boolean isXenDone) {
        this.isXenDone = isXenDone;
    }

    public String getXenNcIp() {
        return xenNcIp;
    }

    public void setXenNcIp(String xenNcIp) {
        this.xenNcIp = xenNcIp;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}