package com.aliyun.app.ws.dto;

import com.aliyun.app.ws.dto.request.BasePageRequestDto;

import java.util.List;

/**
 * Created by wangxiaosan on 16/11/16.
 */
public class QueryTaskDto extends BasePageRequestDto {
    private String regionId;
    private List<String> taskIds;
    private String startTime;
    private String endTime;
    private String taskStatus;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
