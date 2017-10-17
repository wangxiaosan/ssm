package com.wwy.app.model.dto.request;

/**
 * Created by wangxiaosan on 16/11/15.
 */
public class QueryTaskRequestDto extends BasePageRequestDto {
    private String regionId;
    private String taskIds;
    private String startTime;
    private String endTime;
    private String taskStatus;
    private String imageIds;

    public QueryTaskRequestDto(Integer pageNumber, Integer pageSize, String key, String sign, String timeStamp, String requestId, String clientToken, String regionId, String taskIds, String startTime, String endTime, String taskStatus, String imageIds) {
        this(regionId,taskIds,startTime,endTime,taskStatus,imageIds);
        this.setPageNumber(pageNumber);
        this.setPageSize(pageSize);
        this.setKey(key);
        this.setSign(sign);
        this.setTimeStamp(timeStamp);
        this.setRequestId(requestId);
        this.setClientToken(clientToken);
    }

    public QueryTaskRequestDto(String regionId, String taskIds, String startTime, String endTime, String taskStatus, String imageIds) {
        this.regionId = regionId;
        this.taskIds = taskIds;
        this.startTime = startTime;
        this.endTime = endTime;
        this.taskStatus = taskStatus;
        this.imageIds = imageIds;
    }

    public QueryTaskRequestDto() {

    }

    public String getImageIds() {
        return imageIds;
    }

    public void setImageIds(String imageIds) {
        this.imageIds = imageIds;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(String taskIds) {
        this.taskIds = taskIds;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override public String toString() {
        return "QueryTaskRequestDto{" + "regionId='" + regionId + '\'' + ", taskIds='" + taskIds + '\''
                + ", startTime='" + startTime + '\'' + ", endTime='" + endTime + '\'' + ", taskStatus='" + taskStatus + '\''
                + ", imageIds='" + imageIds + '\'' + '}';
    }
}
