package com.wwy.app.model.dto.request;

/**
 * Created by wangxiaosan on 16/11/14.
 */
public class CheckRequestDto extends BaseRequestDto {
    private String regionId;
    private String imageId;
    private String action;
    private String osType;
    private String architecture;
    private String platform;
    private String targetImageFormat;
    private String autoRepair;
    private String configCheckItems;
    private String sourceImageOSSBucket;
    private String sourceImageOSSObject;

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
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

    public String getTargetImageFormat() {
        return targetImageFormat;
    }

    public void setTargetImageFormat(String targetImageFormat) {
        this.targetImageFormat = targetImageFormat;
    }

    public String getAutoRepair() {
        return autoRepair;
    }

    public void setAutoRepair(String autoRepair) {
        this.autoRepair = autoRepair;
    }

    public String getConfigCheckItems() {
        return configCheckItems;
    }

    public void setConfigCheckItems(String configCheckItems) {
        this.configCheckItems = configCheckItems;
    }

    public String getSourceImageOSSBucket() {
        return sourceImageOSSBucket;
    }

    public void setSourceImageOSSBucket(String sourceImageOSSBucket) {
        this.sourceImageOSSBucket = sourceImageOSSBucket;
    }

    public String getSourceImageOSSObject() {
        return sourceImageOSSObject;
    }

    public void setSourceImageOSSObject(String sourceImageOSSObject) {
        this.sourceImageOSSObject = sourceImageOSSObject;
    }
}
