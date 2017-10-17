package com.wwy.app.model.dict;

/**
 * Created by wangxiaosan on 16/11/10.
 */
public enum TaskStatus {
    /**
     * 任务状态-已完成
     */
    Finished,
    /**
     * 任务状态-进行中
     */
    Processing,
    /**
     * 任务状态-未进行
     */
    Pending,
    /**
     * 任务状态-删除
     */
    Deleted,
    /**
     * 任务状态-停止
     */
    Paused,
    /**
     * 任务状态-超时
     */
    Timeout
}
