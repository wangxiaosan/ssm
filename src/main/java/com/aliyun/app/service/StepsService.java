package com.aliyun.app.service;

import com.aliyun.app.ws.dto.request.CancelTaskRequestDto;
import com.aliyun.app.ws.dto.request.CheckRequestDto;
import com.aliyun.app.ws.dto.request.MakeRequestDto;
import com.aliyun.app.ws.dto.request.QueryTaskRequestDto;
import com.aliyun.app.ws.dto.response.CancelTaskResponseDto;
import com.aliyun.app.ws.dto.response.CheckTaskResponseDto;
import com.aliyun.app.ws.dto.response.MakeResponseDto;
import com.aliyun.app.ws.dto.response.QueryTaskResponseDto;

/**
 * Created by wangxiaosan on 16/11/11.
 */
public interface StepsService {

    void makeTask(MakeResponseDto responseDto, MakeRequestDto requestDto);

    void checkTask(CheckTaskResponseDto responseDto, CheckRequestDto requestDto);

    void queryTask(QueryTaskResponseDto responseDto,QueryTaskRequestDto requestDto);

    void cancelTask(CancelTaskResponseDto responseDto, CancelTaskRequestDto requestDto);
}
