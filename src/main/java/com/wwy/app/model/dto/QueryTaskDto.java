package com.wwy.app.model.dto;

import com.wwy.app.model.dto.request.BasePageRequestDto;

import java.util.List;

/**
 * Created by wangxiaosan on 16/11/16.
 */
public class QueryTaskDto extends BasePageRequestDto {
    private String regionId;
    private List<String> taskIds;
    private Long startTime;
    private Long endTime;
    private String taskStatus;
    private List<String> imageIds;

    public List<String> getImageIds() {
        return imageIds;
    }

    public void setImageIds(List<String> imageIds) {
        this.imageIds = imageIds;
    }

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

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override public String toString() {
        return "QueryTaskDto{" + "regionId='" + regionId + '\'' + ", taskIds=" + taskIds + ", startTime=" + startTime
                + ", endTime=" + endTime + ", taskStatus='" + taskStatus + '\'' + ", imageIds=" + imageIds + '}';
    }
}
