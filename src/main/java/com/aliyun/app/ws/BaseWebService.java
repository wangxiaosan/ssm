package com.aliyun.app.ws;

import com.aliyun.app.ws.dto.response.ErrorMetaResponseDto;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangxiaosan on 16/11/18.
 */
public class BaseWebService {

    private final Log log = LogFactory.getLog(BaseWebService.class);

    @ResponseBody
    @ExceptionHandler
    public ErrorMetaResponseDto handleError(HttpServletRequest request, HttpServletResponse response, Exception e){
        log.error(e.getMessage(),e);
        response.setStatus(500);
        ErrorMetaResponseDto errorMetaResponseDto=new ErrorMetaResponseDto();
        errorMetaResponseDto.setMessage(e.getMessage());
        errorMetaResponseDto.setCause(e.getCause()==null?"":e.getCause().getMessage());
        return errorMetaResponseDto;
    }
}
