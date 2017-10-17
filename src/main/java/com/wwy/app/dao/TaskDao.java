package com.wwy.app.dao;

import com.wwy.app.model.dto.CancelTaskDto;
import com.wwy.app.model.dto.QueryTaskDto;
import com.wwy.app.model.dto.TaskDto;
import com.wwy.app.model.entity.TasksDO;

import java.util.List;

/**
 * Created by wangxiaosan on 16/11/11.
 */
public interface TaskDao {
    /**
     * 镜像制作任务
     * @param tasksDO
     * @return
     */
    Long makeTask(TasksDO tasksDO);

    /**
     * 任务查询
     * @param queryTaskDto
     * @return
     */
    List<TaskDto> queryTask(QueryTaskDto queryTaskDto);

    /**
     * 查询总条数
     * @param queryTaskDto
     * @return
     */
    int countTask(QueryTaskDto queryTaskDto);

    /**
     * 查询取消的条数
     * @param cancelTaskDto
     * @return
     */
    int countTaskForCancel(CancelTaskDto cancelTaskDto);

    /**
     * 取消任务
     * @param cancelTaskDto
     */
    void cancelTask(CancelTaskDto cancelTaskDto);

    /**
     * 根据id删除任务
     * @param id
     */
    void deleteTask(Long id);
}
