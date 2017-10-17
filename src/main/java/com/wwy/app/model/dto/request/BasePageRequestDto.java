package com.wwy.app.model.dto.request;

import java.io.Serializable;

/**
 * Created by wangxiaosan on 16/11/11.
 */
public class BasePageRequestDto extends BaseRequestDto implements Serializable {
    private int pageNumber;
    private int pageSize;
    private int offset;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
