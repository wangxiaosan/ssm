package com.wwy.app.service;

import com.wwy.app.model.dto.request.CancelTaskRequestDto;
import com.wwy.app.model.dto.request.CheckRequestDto;
import com.wwy.app.model.dto.request.MakeRequestDto;
import com.wwy.app.model.dto.request.QueryTaskRequestDto;
import com.wwy.app.model.dto.response.CancelTaskResponseDto;
import com.wwy.app.model.dto.response.CheckTaskResponseDto;
import com.wwy.app.model.dto.response.MakeResponseDto;
import com.wwy.app.model.dto.response.QueryTaskResponseDto;

/**
 * Created by wangxiaosan on 16/11/11.
 */
public interface StepsService {

    void makeTask(MakeResponseDto responseDto, MakeRequestDto requestDto);

    void queryTask(QueryTaskResponseDto responseDto, QueryTaskRequestDto requestDto);

    void cancelTask(CancelTaskResponseDto responseDto, CancelTaskRequestDto requestDto);
}
