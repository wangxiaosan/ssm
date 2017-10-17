package com.wwy.app.service.impl;

import com.google.common.collect.Lists;
import com.wwy.app.common.LocalRuntimeException;
import com.wwy.app.common.ResponseCode;
import com.wwy.app.dao.TaskDao;
import com.wwy.app.model.dict.ErrorCode;
import com.wwy.app.model.dict.StorageType;
import com.wwy.app.model.dict.TaskType;
import com.wwy.app.model.dto.CancelTaskDto;
import com.wwy.app.model.dto.QueryTaskDto;
import com.wwy.app.model.dto.TaskDto;
import com.wwy.app.model.dto.request.CancelTaskRequestDto;
import com.wwy.app.model.dto.request.MakeRequestDto;
import com.wwy.app.model.dto.request.QueryTaskRequestDto;
import com.wwy.app.model.dto.response.BaseResponseDto;
import com.wwy.app.model.dto.response.CancelTaskResponseDto;
import com.wwy.app.model.dto.response.MakeResponseDto;
import com.wwy.app.model.dto.response.QueryTaskResponseDto;
import com.wwy.app.model.entity.TasksDO;
import com.wwy.app.service.StepsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang.StringUtils.isBlank;
import static org.apache.commons.lang.StringUtils.isNotBlank;

/**
 * Created by wangxiaosan on 16/11/11.
 */

@Service
public class DefaultStepsService implements StepsService {

    private final Log log = LogFactory.getLog(DefaultStepsService.class);

    @Autowired
    private TaskDao taskDao;

    private static String logMessageFormat = "-----------requestId: %s : %s";

    @Override @Transactional public void makeTask(MakeResponseDto responseDto, MakeRequestDto requestDto) {
        TasksDO tasksDO = new TasksDO();
        //构造用于insert的DO
        obtainTasksDO(tasksDO, requestDto);
        try{
            taskDao.makeTask(tasksDO);
        } catch (LocalRuntimeException e) {
            e.printStackTrace();
            log.error(String.format(logMessageFormat, requestDto.getRequestId(), e.getMessage()), e);
            throw new LocalRuntimeException("make image insert error",ResponseCode.DATA_ACCESS_ERROR, ErrorCode.ErrorOperate.name());
        } catch (Exception e) {
            e.printStackTrace();
            log.error(String.format(logMessageFormat, requestDto.getRequestId(), e.getMessage()), e);
            throw new LocalRuntimeException("make image insert error",ResponseCode.DATA_ACCESS_ERROR, ErrorCode.ErrorOperate.name());
        }
        responseDto.setTaskId(tasksDO.getTaskId());
        responseDto.setTaskType(tasksDO.getTaskType());
        //构造制作成功的返回内容
        obtainResponseDto(responseDto, tasksDO.getRequestId(), Boolean.TRUE, "", "");
    }

    /**
     * 根据dto构造DO
     * @param tasksDO
     * @param requestDto
     */
    private void obtainTasksDO(TasksDO tasksDO, MakeRequestDto requestDto) {
        tasksDO.setTaskType(TaskType.make.name());
        tasksDO.setRegionId(requestDto.getRegionId());
        tasksDO.setImageId(requestDto.getImageId());
        if (isNotBlank(requestDto.getArchitecture())) {
            tasksDO.setArchitecture(requestDto.getArchitecture());
        }
        if (isNotBlank(requestDto.getOSType())) {
            tasksDO.setOsType(requestDto.getOSType());
        }
        if (isNotBlank(requestDto.getOSLanguage())) {
            tasksDO.setLanguage(requestDto.getOSLanguage());
        }
        if (isNotBlank(requestDto.getPlatform())) {
            tasksDO.setPlatform(requestDto.getPlatform());
        }
        tasksDO.setIsInstallWindowsUpdate(getBoolean(requestDto.getPatch()));
        if(isNotBlank(requestDto.getSystemDiskFormat())) {
            tasksDO.setSystemDiskFormat(requestDto.getSystemDiskFormat());
        }
        if (isNotBlank(requestDto.getSystemDiskSize()) && nonNull(stringParseLong(requestDto.getSystemDiskSize()))) {
            tasksDO.setSystemDiskSize(stringParseLong(requestDto.getSystemDiskSize()));
        }
        if (isNotBlank(requestDto.getStorageType()) && StorageType.isExist(requestDto.getStorageType())) {
            tasksDO.setStorageType(StorageType.valueOf(requestDto.getStorageType()).name());
        } else {
            tasksDO.setStorageType(StorageType.oss.name());
        }
        tasksDO.setOssBucket(requestDto.getOssBucket());
        tasksDO.setStorageUrl(requestDto.getSourceSystemOSSObject());
        tasksDO.setStorageChecksum("");
        //测试方便
        if (isNotBlank(requestDto.getStorageCheckSum())) {
            tasksDO.setStorageChecksum(requestDto.getStorageCheckSum());
        }
        tasksDO.setIsKvmEnabled(Boolean.TRUE);
        if (isNotBlank(requestDto.getKvmEnabled())) {
            tasksDO.setIsKvmEnabled(getBoolean(requestDto.getKvmEnabled()));
        }
        tasksDO.setIsXenEnabled(Boolean.TRUE);
        if (isNotBlank(requestDto.getXenEnabled())) {
            tasksDO.setIsXenEnabled(getBoolean(requestDto.getXenEnabled()));
        }
        tasksDO.setUserDefinedScriptUrl(
                isNotBlank(requestDto.getUserDefinedScriptOSSObject()) ? requestDto.getUserDefinedScriptOSSObject() : "");
        tasksDO.setScriptRelatedFileUrl(
                isNotBlank(requestDto.getScriptRelatedFileOSSObject()) ? requestDto.getScriptRelatedFileOSSObject() : "");
        //相同字段抽出
        obtainCommonTasksDo(tasksDO, requestDto.getRequestId());
    }

    public static Boolean getBoolean(String bl) {
        String trueString = "true";
        String yString = "y";
        if (isBlank(bl)) {
            return null;
        }
        if (trueString.equalsIgnoreCase(bl)) {
            return Boolean.TRUE;
        }
        if (yString.equalsIgnoreCase(bl)) {
            return Boolean.TRUE;
        }
        return false;
    }

    /**
     * string parse long
     *
     * @param string
     * @return
     */
    private Long stringParseLong(String string) {
        try {
            Long l = Long.valueOf(string);
            return l;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            return null;
        }
    }

    /**
     * 共同字段抽出
     *
     * @param tasksDO
     * @param requestId
     */
    private void obtainCommonTasksDo(TasksDO tasksDO, String requestId) {
        tasksDO.setGmtCreate(new Date());
        tasksDO.setGmtModify(new Date());
        tasksDO.setAppKey(getUUID());
        tasksDO.setAppSecret(getUUID());
        tasksDO.setSign(getUUID());
        if (isBlank(requestId)) {
            tasksDO.setRequestId(getUUID());
        }
        tasksDO.setClientToken(getUUID());
        tasksDO.setVersion("0");
        tasksDO.setTaskId(getUUID());
        tasksDO.setResultImageOssBucket("");
        tasksDO.setResultImageOssObject("");
        tasksDO.setStartTime(0L);
        tasksDO.setFinishedTime(0L);
    }

    @Override public void queryTask(QueryTaskResponseDto responseDto, QueryTaskRequestDto requestDto) {
        int initPage = 1, initPageSize = 50;
        if (nonNull(requestDto.getPageNumber())) {
            initPage = requestDto.getPageNumber() > 0 ? requestDto.getPageNumber() : 1;
        }
        if (nonNull(requestDto.getPageSize())) {
            initPageSize = requestDto.getPageSize() > 0 ? requestDto.getPageSize() : 50;
        }
        QueryTaskDto queryTaskDto = new QueryTaskDto();
        queryTaskDto.setPageNumber(initPage);
        queryTaskDto.setPageSize(initPageSize);
        queryTaskDto.setOffset((initPage - 1) * initPageSize);
        queryTaskDto.setRegionId(requestDto.getRegionId());
        Long startTime = null;
        Long endTime = null;
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'");
        if (isNotBlank(requestDto.getStartTime())) {
            try {
                startTime = LocalDateTime.parse(requestDto.getStartTime(), f).toEpochSecond(ZoneOffset.UTC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(String.format(logMessageFormat, requestDto.getRequestId(), e.getMessage()),e);
                throw new LocalRuntimeException("startTime invalid", ResponseCode.BAD_REQUEST,
                        ErrorCode.InvalidUTCTime.getValue());
            }
        }
        if (isNotBlank(requestDto.getEndTime())) {
            try {
                endTime = LocalDateTime.parse(requestDto.getEndTime(), f).toEpochSecond(ZoneOffset.UTC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(String.format(logMessageFormat, requestDto.getRequestId(), e.getMessage()),e);
                throw new LocalRuntimeException("endTime invalid", ResponseCode.BAD_REQUEST,
                        ErrorCode.InvalidUTCTime.getValue());
            }
        }
        queryTaskDto.setStartTime(startTime);
        queryTaskDto.setEndTime(endTime);
        queryTaskDto.setTaskStatus(requestDto.getTaskStatus());
        if(isNotBlank(requestDto.getTaskIds())) {
            queryTaskDto.setTaskIds(Arrays.asList(requestDto.getTaskIds().split(",")));
        }
        if(isNotBlank(requestDto.getImageIds())) {
            queryTaskDto.setImageIds(Arrays.asList(requestDto.getImageIds().split(",")));
        }

        List<TaskDto> taskDtoList = Lists.newArrayList();
        int totalCount = 0;
        try {
            taskDtoList = taskDao.queryTask(queryTaskDto);
            totalCount = taskDao.countTask(queryTaskDto);
        } catch (LocalRuntimeException e) {
            e.printStackTrace();
            log.error(String.format(logMessageFormat, requestDto.getRequestId(), e.getMessage()), e);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(String.format(logMessageFormat, requestDto.getRequestId(), e.getMessage()), e);
        }
        responseDto.setRegionId(requestDto.getRegionId());
        responseDto.setTaskSet(taskDtoList);
        responseDto.setTotalCount(totalCount);
        //构造成功的返回内容
        obtainResponseDto(responseDto, requestDto.getRequestId(), Boolean.TRUE, "", "");
    }

    /**
     * 通用－－根据条件构造返回所需要的response
     *
     * @param dto
     * @param requestId
     * @param success
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T extends BaseResponseDto> T obtainResponseDto(T dto, String requestId, Boolean success, String code,
                                                                  String message) {
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
        if (count != taskIds.size()) {
            throw new LocalRuntimeException("The specified tasks is not found.", ResponseCode.BAD_REQUEST,
                    ErrorCode.InvalidTaskIdNotFound.getValue());
        }
        taskDao.cancelTask(cancelTaskDto);
        responseDto.setTaskIds(requestDto.getTaskIds());
        obtainResponseDto(responseDto, requestDto.getRequestId(), Boolean.TRUE, "", "");
    }
}
