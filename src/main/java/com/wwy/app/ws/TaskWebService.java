package com.wwy.app.ws;

import com.alibaba.fastjson.JSON;
import com.wwy.app.common.LocalRuntimeException;
import com.wwy.app.common.ResponseCode;
import com.wwy.app.model.dict.*;
import com.wwy.app.model.dto.request.CancelTaskRequestDto;
import com.wwy.app.model.dto.request.CheckRequestDto;
import com.wwy.app.model.dto.request.MakeRequestDto;
import com.wwy.app.model.dto.request.QueryTaskRequestDto;
import com.wwy.app.model.dto.response.CancelTaskResponseDto;
import com.wwy.app.model.dto.response.CheckTaskResponseDto;
import com.wwy.app.model.dto.response.MakeResponseDto;
import com.wwy.app.model.dto.response.QueryTaskResponseDto;
import com.wwy.app.service.StepsService;
import com.wwy.app.service.impl.DefaultStepsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import static org.apache.commons.lang.StringUtils.*;

/**
 * Created by wangxiaosan on 16/11/11.
 */
@Controller
@RequestMapping("/")
public class TaskWebService extends BaseWebService {

    @Autowired
    private StepsService stepsService;

    private final String TRUE = "true";

    private final String FALSE = "false";

    @RequestMapping(value = "make", method = RequestMethod.POST)
    @ResponseBody
    public MakeResponseDto makeTask(@NotNull @RequestBody MakeRequestDto requestDto) {
        if (isBlank(requestDto.getKey())) {
            throw new LocalRuntimeException("The input parameter “Key” that is mandatory for processing this request is not supplied", ResponseCode.BAD_REQUEST, ErrorCode.MissingParameter.getValue());
        }
        if (isBlank(requestDto.getRegionId())) {
            throw new LocalRuntimeException("An input parameter \\\"RegionId\\\" that is mandatory for processing the request is not supplied.", ResponseCode.BAD_REQUEST, ErrorCode.MissingParameter.getValue());
        }
        if (isBlank(requestDto.getImageId())) {
            throw new LocalRuntimeException("An input parameter \\\"ImageId\\\" that is mandatory for processing the request is not supplied.", ResponseCode.BAD_REQUEST, ErrorCode.MissingParameter.getValue());
        }
        if(isBlank(requestDto.getPlatform())) {
            throw new LocalRuntimeException("An input parameter \\\"Platform\\\" that is mandatory for processing the request is not supplied.", ResponseCode.BAD_REQUEST, ErrorCode.MissingParameter.getValue());
        }
        if (isBlank(requestDto.getOssBucket())) {
            throw new LocalRuntimeException("An input parameter \\\"OSSBucket\\\" that is mandatory for processing the request is not supplied.", ResponseCode.BAD_REQUEST, ErrorCode.MissingParameter.getValue());
        }
        if (isBlank(requestDto.getSourceSystemOSSObject())) {
            throw new LocalRuntimeException("An input parameter \\\"SourceSystemOSSObject\\\" that is mandatory for processing the request is not supplied.", ResponseCode.BAD_REQUEST, ErrorCode.MissingParameter.getValue());
        }
        if (isNotBlank(requestDto.getOSType()) && !OsType.isExist(requestDto.getOSType())) {
            throw new LocalRuntimeException("The specified OSType is wrongly formed.", ResponseCode.BAD_REQUEST, ErrorCode.InvalidOSTypeMalformed.getValue());
        }
        if (isNotBlank(requestDto.getSystemDiskFormat()) && !SystemDiskFormat.isExist(requestDto.getSystemDiskFormat())) {
            throw new LocalRuntimeException("The specified SystemDiskFormat is wrongly formed.", ResponseCode.BAD_REQUEST, ErrorCode.InvalidFormatMalformed.getValue());
        }
        if (isNotBlank(requestDto.getPatch()) && !(TRUE.equalsIgnoreCase(requestDto.getPatch()) || FALSE.equalsIgnoreCase(requestDto.getPatch()))) {
            throw new LocalRuntimeException("The specified WindowsPatch is wrongly formed.", ResponseCode.BAD_REQUEST, ErrorCode.InvalidWindowsPatchMalformed.getValue());
        }
        if (isNotBlank(requestDto.getArchitecture()) && !Architecture.isExist(requestDto.getArchitecture())) {
            throw new LocalRuntimeException("The specified Architecture is wrongly formed.", ResponseCode.BAD_REQUEST, ErrorCode.InvalidArchitecture.getValue());
        }
        if (isNotBlank(requestDto.getOSLanguage()) && !LanguageType.isExist(requestDto.getOSLanguage())) {
            throw new LocalRuntimeException("The specified OsLanguage is wrongly formed.", ResponseCode.BAD_REQUEST, ErrorCode.InvalidOsLanguage.getValue());
        }
        if (!PlatForm.isExist(requestDto.getPlatform())) {
            throw new LocalRuntimeException("The specified Platform is wrongly formed.", ResponseCode.BAD_REQUEST, ErrorCode.MissingParameter.getValue());
        }
        if(isNotBlank(requestDto.getSystemDiskSize())&&!isNumeric(requestDto.getSystemDiskSize())) {
            throw new LocalRuntimeException("The specified SystemDiskSize is wrongly formed.", ResponseCode.BAD_REQUEST, ErrorCode.InvalidSystemDiskSize.getValue());
        }
        if(isBlank(requestDto.getSign())) {
            throw new LocalRuntimeException("The input parameter “sign” that is mandatory for processing this request is not supplied", ResponseCode.BAD_REQUEST, ErrorCode.MissingParameter.getValue());
        }
        MakeResponseDto responseDto = new MakeResponseDto();
        stepsService.makeTask(responseDto, requestDto);
        return responseDto;
    }

    @RequestMapping(value = "image/task/query", method = RequestMethod.GET)
    @ResponseBody
    public QueryTaskResponseDto queryTask(HttpServletRequest request) {
        QueryTaskRequestDto requestDto = new QueryTaskRequestDto(Integer.valueOf(request.getHeader("pageNumber")),
                Integer.valueOf(request.getHeader("pageSize")),
                request.getHeader("key"), request.getHeader("sign"),
                request.getHeader("timeStamp"), request.getHeader("requestId"),
                request.getHeader("clientToken"), request.getHeader("regionId"),
                request.getHeader("taskIds"), request.getHeader("startTime"),
                request.getHeader("endTime"), request.getHeader("taskStatus"), request.getHeader("imageIds"));
        QueryTaskResponseDto responseDto = new QueryTaskResponseDto();
        responseDto.setRegionId(requestDto.getRegionId());
        if (isBlank(requestDto.getKey())) {
            throw new LocalRuntimeException("The input parameter “Key” that is mandatory for processing this request is not supplied", ResponseCode.BAD_REQUEST, ErrorCode.MissingParameter.getValue());
        }
        if (isBlank(requestDto.getRegionId())) {
            throw new LocalRuntimeException("An input parameter \\\"RegionId\\\" that is mandatory for processing the request is not supplied.", ResponseCode.BAD_REQUEST, ErrorCode.MissingParameter.getValue());
        }
        if (isBlank(requestDto.getTaskIds())) {
            throw new LocalRuntimeException("An input parameter \\\"TaskIds\\\" that is mandatory for processing the request is not supplied.", ResponseCode.BAD_REQUEST, ErrorCode.MissingParameter.getValue());
        }
        if(isBlank(requestDto.getSign())) {
            throw new LocalRuntimeException("The input parameter “sign” that is mandatory for processing this request is not supplied", ResponseCode.BAD_REQUEST, ErrorCode.MissingParameter.getValue());
        }
        stepsService.queryTask(responseDto, requestDto);
        return responseDto;
    }

    @RequestMapping(value = "image/task/cancel",method = RequestMethod.POST)
    @ResponseBody
    public CancelTaskResponseDto cancelTask(@NotNull CancelTaskRequestDto requestDto) {
        CancelTaskResponseDto responseDto = new CancelTaskResponseDto();
        if(isBlank(requestDto.getKey())) {
            DefaultStepsService.obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.MissingParameter.getValue(),"The input parameter “Key” that is mandatory for processing this request is not supplied");
            return responseDto;
        }
        if(isBlank(requestDto.getRegionId())) {
            DefaultStepsService.obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.MissingParameter.getValue(),"An input parameter \\\"RegionId\\\" that is mandatory for processing the request is not supplied.");
            return responseDto;
        }
        if(isBlank(requestDto.getTaskIds())) {
            DefaultStepsService.obtainResponseDto(responseDto,requestDto.getRequestId(),Boolean.FALSE,ErrorCode.MissingParameter.getValue(),"An input parameter \\\"TaskIds\\\" that is mandatory for processing the request is not supplied.");
            return responseDto;
        }
        stepsService.cancelTask(responseDto,requestDto);
        return responseDto;
    }


}
