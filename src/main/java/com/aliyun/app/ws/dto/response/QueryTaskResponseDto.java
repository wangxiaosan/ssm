package com.aliyun.app.ws.dto.response;

import com.aliyun.app.ws.dto.TaskDto;

import java.util.List;

/**
 * Created by wangxiaosan on 16/11/15.
 */
public class QueryTaskResponseDto extends BaseResponseDto {
    private String regionId;
    private List<TaskDto> taskSet;
    private int totalCount;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public List<TaskDto> getTaskSet() {
        return taskSet;
    }

    public void setTaskSet(List<TaskDto> taskSet) {
        this.taskSet = taskSet;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
