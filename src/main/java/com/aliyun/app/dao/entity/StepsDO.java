package com.aliyun.app.dao.entity;

/**
 * Created by wangxiaosan on 16/11/9.
 */
public class StepsDO {
    /**
     * create table if not exists steps(
     id bigint auto_increment not null,
     taskId varchar(128) not null,
     stepId varchar(128) not null,
     stepOk boolean default false,
     stepResult varchar(1024) default null,
     primary key(id),
     unique key idxStepId(stepId)) character set utf8;
     */
    private long id;
    private String taskId;
    private String stepId;
    private Boolean stepOK;
    private String stepResult;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public Boolean getStepOK() {
        return stepOK;
    }

    public void setStepOK(Boolean stepOK) {
        this.stepOK = stepOK;
    }

    public String getStepResult() {
        return stepResult;
    }

    public void setStepResult(String stepResult) {
        this.stepResult = stepResult;
    }
}
