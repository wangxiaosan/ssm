package com.wwy.app.model.dto;

/**
 * Created by wangxiaosan on 16/12/14.
 */
public class CheckResultDto {
    private String itemName;
    private String itemDesc;
    private String itemLabel;
    private Boolean ok;
    private String info;
    private Boolean fixEnabled;
    private Boolean fixOk;
    private String fixInfo;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(String itemLabel) {
        this.itemLabel = itemLabel;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean getFixEnabled() {
        return fixEnabled;
    }

    public void setFixEnabled(Boolean fixEnabled) {
        this.fixEnabled = fixEnabled;
    }

    public Boolean getFixOk() {
        return fixOk;
    }

    public void setFixOk(Boolean fixOk) {
        this.fixOk = fixOk;
    }

    public String getFixInfo() {
        return fixInfo;
    }

    public void setFixInfo(String fixInfo) {
        this.fixInfo = fixInfo;
    }

    @Override
    public String toString() {
        return "CheckResultDto{" +
                "itemName='" + itemName + '\'' +
                ", itemDesc='" + itemDesc + '\'' +
                ", itemLabel='" + itemLabel + '\'' +
                ", ok=" + ok +
                ", info='" + info + '\'' +
                ", fixEnabled=" + fixEnabled +
                ", fixOk=" + fixOk +
                ", fixInfo='" + fixInfo + '\'' +
                '}';
    }
}
