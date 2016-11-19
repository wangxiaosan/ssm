package com.aliyun.app.ws.dto.request;

import com.sun.istack.NotNull;

/**
 * Created by wangxiaosan on 16/11/11.
 */
public class MakeRequestDto extends BaseRequestDto {
    private String regionId;
    private String imageId;
    private String architecture;
    private String osType;
    private String osLanguage;
    private String platform;
    private String patch;
    private String systemDiskFormat;
    private String systemDiskSize;
    private String ossBucket;
    private String sourceSystemOSSObject;
    private String userDefinedScriptOSSObject;
    private String scriptRelatedFileOSSObject;

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

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getOsLanguage() {
        return osLanguage;
    }

    public void setOsLanguage(String osLanguage) {
        this.osLanguage = osLanguage;
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
}
