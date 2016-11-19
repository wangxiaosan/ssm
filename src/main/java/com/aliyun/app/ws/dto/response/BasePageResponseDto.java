package com.aliyun.app.ws.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wangxiaosan on 16/11/11.
 */
public class BasePageResponseDto<T> implements Iterable<T> ,Serializable {

    public final static int MAX_RECORDS = 1000;

    private List<T> content = new ArrayList<T>();
    private long TotalCount;
    private int size;
    private int page;

    public BasePageResponseDto(int page, int size) {
        this(null, page, size , 0);
    }

    public BasePageResponseDto(List<T> content) {
        this(content, 0, 0 , null == content ? 0 : content.size());
    }

    public BasePageResponseDto(List<T> content, int page, int size, long total) {
        if (null != content) {
            this.content.addAll(content);
        }
        this.TotalCount = total;
        this.size = size;
        this.page = page;
    }

    public int getSize() {
        return size == 0 ? MAX_RECORDS : size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page <= 0 ? 1 : page;
    }

    public void setPage(int page) {
        this.page = page;
    }


    public int getTotalPages() {
        int ceil = (int) Math.ceil((double) TotalCount / (double) getSize());
        return getSize() == 0 ? 0 : ceil;
    }

    public int getNumberOfElements() {
        return content.size();
    }

    public void setTotalCount(long totalCount) {
        this.TotalCount = totalCount;
    }

    public long getTotalCount() {
        return TotalCount;
    }

    public boolean hasPreviousPage() {
        return getPage() > 1;
    }

    public boolean isFirstPage() {
        return !hasPreviousPage();
    }

    public boolean hasNextPage() {
        return getPage() * getSize() < TotalCount;
    }

    public boolean isLastPage() {
        return !hasNextPage();
    }

    public Iterator<T> iterator() {
        return content.iterator();
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public List<T> getContent() {
        return content;
    }

    public boolean hasContent() {
        return !content.isEmpty();
    }


}
