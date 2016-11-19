package com.aliyun.app.ws;

import com.aliyun.app.common.ErrorCode;
import com.aliyun.app.dao.dict.OsType;
import com.aliyun.app.service.StepsService;
import com.aliyun.app.ws.dto.request.CancelTaskRequestDto;
import com.aliyun.app.ws.dto.request.CheckRequestDto;
import com.aliyun.app.ws.dto.request.MakeRequestDto;
import com.aliyun.app.ws.dto.request.QueryTaskRequestDto;
import com.aliyun.app.ws.dto.response.CancelTaskResponseDto;
import com.aliyun.app.ws.dto.response.CheckTaskResponseDto;
import com.aliyun.app.ws.dto.response.MakeResponseDto;
import com.aliyun.app.ws.dto.response.QueryTaskResponseDto;
import com.sun.istack.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.aliyun.app.service.impl.DefaultStepsService.obtainResponseDto;
import static org.apache.commons.lang.StringUtils.isBlank;
import static org.apache.commons.lang.StringUtils.isNotBlank;

/**
 * Created by wangxiaosan on 16/11/11.
 */
@Controller
@RequestMapping("/")
public class TaskWebService extends BaseWebService {


    @Autowired
    private StepsService stepsService;

    @RequestMapping(value = "make",method = RequestMethod.POST)
    @ResponseBody
    public MakeResponseDto makeTask(@NotNull @Validated MakeRequestDto requestDto) {
        MakeResponseDto responseDto = new MakeResponseDto();
        if(isBlank(requestDto.getKey())) {
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.MissingParameter.getValue(),"The input parameter “Key” that is mandatory for processing this request is not supplied");
            return responseDto;
        }
        if(isBlank(requestDto.getRegionId())) {
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.MissingParameter.getValue(),"An input parameter \\\"RegionId\\\" that is mandatory for processing the request is not supplied.");
            return responseDto;
        }
        if(isBlank(requestDto.getImageId())) {
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.MissingParameter.getValue(),"An input parameter \\\"ImageId\\\" that is mandatory for processing the request is not supplied.");
            return responseDto;
        }
        if(isBlank(requestDto.getOssBucket())) {
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.MissingParameter.getValue(),"An input parameter \\\"OSSBucket\\\" that is mandatory for processing the request is not supplied.");
            return responseDto;
        }
        if(isBlank(requestDto.getSourceSystemOSSObject())) {
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.MissingParameter.getValue(),"An input parameter \\\"SourceSystemOSSObject\\\" that is mandatory for processing the request is not supplied.");
            return responseDto;
        }
        if(isNotBlank(requestDto.getOsType()) && !OsType.isExist(requestDto.getOsType())) {
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.InvalidOSTypeMalformed.getValue(),"The specified OSType is wrongly formed.");
            return responseDto;
        }
        //TODO SystemDiskFormat
        //TODO WindowsPatch
        //TODO OSSBucket forbbiden && notFound
        //TODO SourceSystemOSSObjectis notFound
        //TODO ScriptRelateFileOSSObject notFound
        stepsService.makeTask(responseDto,requestDto);
        return responseDto;
    }

    @RequestMapping(value = "check",method = RequestMethod.POST)
    @ResponseBody
    public CheckTaskResponseDto checkTask(@NotNull @Validated CheckRequestDto requestDto) {
        CheckTaskResponseDto responseDto = new CheckTaskResponseDto();
        if(isBlank(requestDto.getKey())) {
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.MissingParameter.getValue(),"The input parameter “Key” that is mandatory for processing this request is not supplied");
            return responseDto;
        }
        if(isBlank(requestDto.getRegionId())) {
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.MissingParameter.getValue(),"An input parameter \\\"RegionId\\\" that is mandatory for processing the request is not supplied.");
            return responseDto;
        }
        if(isNotBlank(requestDto.getOsType()) && !OsType.isExist(requestDto.getOsType())) {
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.InvalidOSTypeMalformed.getValue(),"The specified OSType is wrongly formed.");
            return responseDto;
        }
        if(isBlank(requestDto.getImageId())) {
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.MissingParameter.getValue(),"An input parameter \\\"ImageId\\\" that is mandatory for processing the request is not supplied.");
            return responseDto;
        }
        //TODO TargetImageFormat
        //TODO OSSBucket forbbiden && notFound
        //TODO SourceImageOssObject notFound
        stepsService.checkTask(responseDto,requestDto);
        return responseDto;
    }

    @RequestMapping(value = "image/task/query",method = RequestMethod.POST)
    @ResponseBody
    public QueryTaskResponseDto queryTask(@NotNull QueryTaskRequestDto requestDto ) {
        QueryTaskResponseDto responseDto = new QueryTaskResponseDto();
        responseDto.setRegionId(requestDto.getRegionId());
        if(isBlank(requestDto.getKey())) {
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.MissingParameter.getValue(),"The input parameter “Key” that is mandatory for processing this request is not supplied");
            return responseDto;
        }
        if(isBlank(requestDto.getRegionId())) {
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.MissingParameter.getValue(),"An input parameter \\\"RegionId\\\" that is mandatory for processing the request is not supplied.");
            return responseDto;
        }
        if(isBlank(requestDto.getTaskIds())) {
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.MissingParameter.getValue(),"An input parameter \\\"TaskIds\\\" that is mandatory for processing the request is not supplied.");
            return responseDto;
        }
        stepsService.queryTask(responseDto,requestDto);
        return responseDto;
    }

    @RequestMapping(value = "image/task/cancel",method = RequestMethod.POST)
    @ResponseBody
    public CancelTaskResponseDto cancelTask(@NotNull CancelTaskRequestDto requestDto) {
        CancelTaskResponseDto responseDto = new CancelTaskResponseDto();
        if(isBlank(requestDto.getKey())) {
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.MissingParameter.getValue(),"The input parameter “Key” that is mandatory for processing this request is not supplied");
            return responseDto;
        }
        if(isBlank(requestDto.getRegionId())) {
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.MissingParameter.getValue(),"An input parameter \\\"RegionId\\\" that is mandatory for processing the request is not supplied.");
            return responseDto;
        }
        if(isBlank(requestDto.getTaskIds())) {
            obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.MissingParameter.getValue(),"An input parameter \\\"TaskIds\\\" that is mandatory for processing the request is not supplied.");
            return responseDto;
        }
        stepsService.cancelTask(responseDto,requestDto);
        return responseDto;
    }


}
