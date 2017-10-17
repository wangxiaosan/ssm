package com.wwy.app.model.dto.response;

/**
 * Created by wangxiaosan on 16/11/17.
 */
public class CancelTaskResponseDto extends BaseResponseDto {
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
