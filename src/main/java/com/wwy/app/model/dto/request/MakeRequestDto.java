package com.wwy.app.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by wangxiaosan on 16/11/11.
 */
public class MakeRequestDto extends BaseRequestDto {
    private String regionId;
    private String imageId;
    private String architecture;
    @JsonProperty("oSType")
    private String oSType;
    @JsonProperty("oSLanguage")
    private String oSLanguage;
    private String platform;
    private String patch;
    private String systemDiskFormat;
    private String systemDiskSize;
    private String ossBucket;
    private String sourceSystemOSSObject;
    private String userDefinedScriptOSSObject;
    private String scriptRelatedFileOSSObject;
    /**以下字段为方便测试添加
     *
     */
    private String storageType;
    private String storageCheckSum;
    private String kvmEnabled;
    private String xenEnabled;

    public String getKvmEnabled() {
        return kvmEnabled;
    }

    public void setKvmEnabled(String kvmEnabled) {
        this.kvmEnabled = kvmEnabled;
    }

    public String getXenEnabled() {
        return xenEnabled;
    }

    public void setXenEnabled(String xenEnabled) {
        this.xenEnabled = xenEnabled;
    }

    public String getStorageCheckSum() {
        return storageCheckSum;
    }

    public void setStorageCheckSum(String storageCheckSum) {
        this.storageCheckSum = storageCheckSum;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
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

    public String getPatch() {
        return patch;
    }

    public void setPatch(String patch) {
        this.patch = patch;
    }

    public String getSystemDiskFormat() {
        return systemDiskFormat;
    }

    public void setSystemDiskFormat(String systemDiskFormat) {
        this.systemDiskFormat = systemDiskFormat;
    }

    public String getSystemDiskSize() {
        return systemDiskSize;
    }

    public void setSystemDiskSize(String systemDiskSize) {
        this.systemDiskSize = systemDiskSize;
    }

    public String getOssBucket() {
        return ossBucket;
    }

    public void setOssBucket(String ossBucket) {
        this.ossBucket = ossBucket;
    }

    public String getSourceSystemOSSObject() {
        return sourceSystemOSSObject;
    }

    public void setSourceSystemOSSObject(String sourceSystemOSSObject) {
        this.sourceSystemOSSObject = sourceSystemOSSObject;
    }

    public String getUserDefinedScriptOSSObject() {
        return userDefinedScriptOSSObject;
    }

    public void setUserDefinedScriptOSSObject(String userDefinedScriptOSSObject) {
        this.userDefinedScriptOSSObject = userDefinedScriptOSSObject;
    }

    public String getScriptRelatedFileOSSObject() {
        return scriptRelatedFileOSSObject;
    }

    public void setScriptRelatedFileOSSObject(String scriptRelatedFileOSSObject) {
        this.scriptRelatedFileOSSObject = scriptRelatedFileOSSObject;
    }

    public String getOSType() {
        return oSType;
    }

    public void setOSType(String oSType) {
        this.oSType = oSType;
    }

    public String getOSLanguage() {
        return oSLanguage;
    }

    public void setOSLanguage(String oSLanguage) {
        this.oSLanguage = oSLanguage;
    }

    @Override
    public String toString() {
        return "MakeRequestDto{" +
                "regionId='" + regionId + '\'' +
                ", imageId='" + imageId + '\'' +
                ", architecture='" + architecture + '\'' +
                ", oSType='" + oSType + '\'' +
                ", oSLanguage='" + oSLanguage + '\'' +
                ", platform='" + platform + '\'' +
                ", patch='" + patch + '\'' +
                ", systemDiskFormat='" + systemDiskFormat + '\'' +
                ", systemDiskSize='" + systemDiskSize + '\'' +
                ", ossBucket='" + ossBucket + '\'' +
                ", sourceSystemOSSObject='" + sourceSystemOSSObject + '\'' +
                ", userDefinedScriptOSSObject='" + userDefinedScriptOSSObject + '\'' +
                ", scriptRelatedFileOSSObject='" + scriptRelatedFileOSSObject + '\'' +
                ", storageType='" + storageType + '\'' +
                ", storageCheckSum='" + storageCheckSum + '\'' +
                ", kvmEnabled='" + kvmEnabled + '\'' +
                ", xenEnabled='" + xenEnabled + '\'' +
                '}';
    }
}
