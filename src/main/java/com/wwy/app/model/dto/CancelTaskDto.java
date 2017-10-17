package com.wwy.app.model.dto;

import com.wwy.app.model.dto.request.BaseRequestDto;

import java.util.List;

/**
 * Created by wangxiaosan on 16/11/17.
 */
public class CancelTaskDto extends BaseRequestDto {
    private String regionId;
    private List<String> taskIds;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public List<String> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<String> taskIds) {
        this.taskIds = taskIds;
    }
}
