package com.wwy.app.model.dto.request;

/**
 * Created by wangxiaosan on 16/11/17.
 */
public class CancelTaskRequestDto extends BaseRequestDto {
    private String regionId;
    private String taskIds;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(String taskIds) {
        this.taskIds = taskIds;
    }
}
