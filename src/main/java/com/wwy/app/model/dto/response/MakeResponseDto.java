package com.wwy.app.model.dto.response;

/**
 * Created by wangxiaosan on 16/11/11.
 */
public class MakeResponseDto extends BaseResponseDto {
    private String taskId;
    private String taskType;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
}
