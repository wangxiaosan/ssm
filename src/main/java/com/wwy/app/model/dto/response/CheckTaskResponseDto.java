package com.wwy.app.model.dto.response;

/**
 * Created by wangxiaosan on 16/11/14.
 */
public class CheckTaskResponseDto extends BaseResponseDto {
    private String taskId;
    private String taskType;
    private String repairImageOSSBucket;
    private String repairImageOSSObject;

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

    public String getRepairImageOSSBucket() {
        return repairImageOSSBucket;
    }

    public void setRepairImageOSSBucket(String repairImageOSSBucket) {
        this.repairImageOSSBucket = repairImageOSSBucket;
    }

    public String getRepairImageOSSObject() {
        return repairImageOSSObject;
    }

    public void setRepairImageOSSObject(String repairImageOSSObject) {
        this.repairImageOSSObject = repairImageOSSObject;
    }
}
