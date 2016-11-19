package com.aliyun.app.dao;

import com.aliyun.app.dao.entity.TasksDO;
import com.aliyun.app.ws.dto.CancelTaskDto;
import com.aliyun.app.ws.dto.QueryTaskDto;
import com.aliyun.app.ws.dto.TaskDto;
import com.aliyun.app.ws.dto.response.CheckTaskResponseDto;
import com.aliyun.app.ws.dto.response.MakeResponseDto;

import java.util.List;

/**
 * Created by wangxiaosan on 16/11/11.
 */
public interface TaskDao {
    Long makeTask(TasksDO tasksDO);

    MakeResponseDto findTask(Long id);

    Long checkTask(TasksDO tasksDO);

    CheckTaskResponseDto findCheckTask(Long id);

    List<TaskDto> queryTask(QueryTaskDto queryTaskDto);

    int countTask(QueryTaskDto queryTaskDto);

    int countTaskForCancel(CancelTaskDto cancelTaskDto);

    void cancelTask(CancelTaskDto cancelTaskDto);
}
