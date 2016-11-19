package com.aliyun.app.service.impl;

import com.aliyun.app.common.ErrorCode;
import com.aliyun.app.dao.TaskDao;
import com.aliyun.app.dao.dict.Architecture;
import com.aliyun.app.dao.dict.LanguageType;
import com.aliyun.app.dao.dict.OsType;
import com.aliyun.app.dao.dict.PlatForm;
import com.aliyun.app.dao.dict.TargetImageFormat;
import com.aliyun.app.dao.dict.TaskType;
import com.aliyun.app.dao.entity.TasksDO;
import com.aliyun.app.service.StepsService;
import com.aliyun.app.ws.dto.CancelTaskDto;
import com.aliyun.app.ws.dto.QueryTaskDto;
import com.aliyun.app.ws.dto.TaskDto;
import com.aliyun.app.ws.dto.request.CancelTaskRequestDto;
import com.aliyun.app.ws.dto.request.CheckRequestDto;
import com.aliyun.app.ws.dto.request.MakeRequestDto;
import com.aliyun.app.ws.dto.request.QueryTaskRequestDto;
import com.aliyun.app.ws.dto.response.BaseResponseDto;
import com.aliyun.app.ws.dto.response.CancelTaskResponseDto;
import com.aliyun.app.ws.dto.response.CheckTaskResponseDto;
import com.aliyun.app.ws.dto.response.MakeResponseDto;
import com.aliyun.app.ws.dto.response.QueryTaskResponseDto;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.apache.commons.lang.StringUtils.isBlank;

/**
 * Created by wangxiaosan on 16/11/11.
 */

@Service
public class DefaultStepsService implements StepsService {

    private final Log log = LogFactory.getLog(DefaultStepsService.class);

    @Autowired
    private TaskDao taskDao;

    @Override
    @Transactional
    public void makeTask(MakeResponseDto responseDto, MakeRequestDto requestDto) {
        TasksDO tasksDO = new TasksDO();
        //构造用于insert的DO
        obtainTasksDO(tasksDO,requestDto);
        Long id = taskDao.makeTask(tasksDO);
        MakeResponseDto dto = taskDao.findTask(id);
        responseDto.setTaskId(dto.getTaskId());
        responseDto.setTaskType(dto.getTaskType());
        //构造制作成功的返回内容
        obtainResponseDto(responseDto,dto.getRequestId(),Boolean.TRUE,"","");
    }

    /**
     * 根据dto构造DO
     * @param tasksDO
     * @param requestDto
     */
    private void obtainTasksDO(TasksDO tasksDO, MakeRequestDto requestDto) {
        tasksDO.setTaskType(TaskType.make);
        tasksDO.setRegionId(requestDto.getRegionId());
        tasksDO.setImageId(requestDto.getImageId());
        tasksDO.setArchitecture(Architecture.valueOf(requestDto.getArchitecture()));
        tasksDO.setOsType(OsType.valueOf(requestDto.getOsType()));
        tasksDO.setLanguage(LanguageType.valueOf(requestDto.getOsLanguage()));
        tasksDO.setPlatform(PlatForm.valueOf(requestDto.getPlatform()).getValue());
        tasksDO.setPatch(Boolean.getBoolean(requestDto.getPatch()));
        tasksDO.setSystemDiskFormat(requestDto.getSystemDiskFormat());
        tasksDO.setSystemDiskSize(Long.valueOf(requestDto.getSystemDiskSize()));
        tasksDO.setOssBucket(requestDto.getOssBucket());
        tasksDO.setSourceSystemOssObject(requestDto.getSourceSystemOSSObject());
        tasksDO.setUserDefinedScriptOssObject(requestDto.getUserDefinedScriptOSSObject());
        tasksDO.setScriptRelatedFileOssObject(requestDto.getScriptRelatedFileOSSObject());
        tasksDO.setSourceSystemOssChecksum("");
        tasksDO.setSourceImageOssBucket("");
        tasksDO.setSourceImageOssObject("");
        //相同字段抽出
        obtainCommonTasksDo(tasksDO,requestDto.getRequestId());
    }

    //共同字段抽出
    private void obtainCommonTasksDo(TasksDO tasksDO,String requestId) {
        tasksDO.setAppKey(getUUID());
        tasksDO.setAppSecret(getUUID());
        tasksDO.setSign(getUUID());
        if(isBlank(requestId)){
            tasksDO.setRequestId(getUUID());
        }
        tasksDO.setClientToken(getUUID());
        tasksDO.setVersion(0L);
        tasksDO.setSourceSystemOssChecksum("");
        tasksDO.setSourceImageOssChecksum("");
        tasksDO.setTaskId(getUUID());
        tasksDO.setResultIamgeOssBucket("");
        tasksDO.setResultIamgeOssObject("");
        tasksDO.setStartTime(0);
        tasksDO.setEndTime(0);
        tasksDO.setLastUpdateTime(0);
        tasksDO.setCurrentStepId("");
        tasksDO.setTotalSteps(0);
        tasksDO.setRemainingSteps(0);
    }

    @Override
    public void checkTask(CheckTaskResponseDto responseDto, CheckRequestDto requestDto) {
        TasksDO tasksDO = new TasksDO();
        //构造用于check的DO
        obtainCheckTask(tasksDO,requestDto);
        Long id = taskDao.checkTask(tasksDO);
        CheckTaskResponseDto dto = taskDao.findCheckTask(id);
        responseDto.setTaskType(dto.getTaskType());
        responseDto.setTaskId(dto.getTaskId());
        //构造成功的返回内容
        obtainResponseDto(responseDto,dto.getRequestId(),Boolean.TRUE,"","");
    }

    /**
     * 根据条件构造check所需要的DO
     * @param tasksDO
     * @param requestDto
     */
    private void obtainCheckTask(TasksDO tasksDO, CheckRequestDto requestDto) {
        tasksDO.setRegionId(requestDto.getRegionId());
        tasksDO.setImageId(requestDto.getImageId());
        tasksDO.setTaskType(TaskType.check);
        if (TaskType.convert.equals(requestDto.getAction())) {
            tasksDO.setTaskType(TaskType.convert);
        }
        tasksDO.setArchitecture(Architecture.valueOf(requestDto.getArchitecture()));
        tasksDO.setOsType(OsType.valueOf(requestDto.getOsType()));
        tasksDO.setPlatform(PlatForm.valueOf(requestDto.getPlatform()).getValue());
        tasksDO.setTargetImageFormat(TargetImageFormat.valueOf(requestDto.getTargetImageFormat()));
        tasksDO.setAutoRepair(Boolean.getBoolean(requestDto.getAutoRepair()));
        //TODO configCheckItems
        //格式如：{enable:"",disable:""},enable与disable分别代表需要检测与跳过的配置项集合，可以单独配置或者为空
        tasksDO.setSourceImageOssBucket(requestDto.getSourceImageOSSBucket());
        tasksDO.setSourceImageOssObject(requestDto.getSourceImageOSSObject());
        tasksDO.setOssBucket("");
        tasksDO.setSourceSystemOssObject("");
        tasksDO.setUserDefinedScriptOssObject("");
        tasksDO.setScriptRelatedFileOssObject("");
        obtainCommonTasksDo(tasksDO,requestDto.getRequestId());
    }

    @Override
    public void queryTask(QueryTaskResponseDto responseDto, QueryTaskRequestDto requestDto) {
        QueryTaskDto queryTaskDto = new QueryTaskDto();
        queryTaskDto.setPageNumber(requestDto.getPageNumber());
        queryTaskDto.setPageSize(requestDto.getPageSize());
        queryTaskDto.setOffset((requestDto.getPageNumber()-1)*requestDto.getPageSize());
        queryTaskDto.setRegionId(requestDto.getRegionId());
        queryTaskDto.setStartTime(requestDto.getStartTime());
        queryTaskDto.setEndTime(requestDto.getEndTime());
        queryTaskDto.setTaskStatus(requestDto.getTaskStatus());
        queryTaskDto.setTaskIds(Arrays.asList(requestDto.getTaskIds().split(",")));
        List<TaskDto> taskDtos = taskDao.queryTask(queryTaskDto);
        int totalCount = taskDao.countTask(queryTaskDto);
        responseDto.setRegionId(requestDto.getRegionId());
        responseDto.setTaskSet(taskDtos);
        responseDto.setTotalCount(totalCount);
        //构造成功的返回内容
        obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.TRUE,"","");
    }

    /**
     * 通用－－根据条件构造返回所需要的response
     * @param dto
     * @param requestId
     * @param success
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T extends BaseResponseDto > T obtainResponseDto(T dto, String requestId, Boolean success, String code ,String message){
        dto.setRequestId(requestId);
        dto.setSuccess(success);
        dto.setCode(code);
        dto.setMessage(message);
        return dto;
    }

    /**
     * uuid
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }


    @Override
    public void cancelTask(CancelTaskResponseDto responseDto, CancelTaskRequestDto requestDto) {
        CancelTaskDto cancelTaskDto = new CancelTaskDto();
        cancelTaskDto.setRegionId(requestDto.getRegionId());
        List<String> taskIds = Arrays.asList(requestDto.getTaskIds().split(","));
        cancelTaskDto.setTaskIds(taskIds);
        int count = taskDao.countTaskForCancel(cancelTaskDto);
        if(count != taskIds.size()) {
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE, ErrorCode.InvalidTaskIdNotFoun.getValue(),"The specified taskId is not found.");
        } else {
            taskDao.cancelTask(cancelTaskDto);
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.TRUE, "","");
        }
    }
}
