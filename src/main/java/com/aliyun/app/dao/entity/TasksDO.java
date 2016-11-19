package com.aliyun.app.dao.entity;

import com.aliyun.app.dao.dict.Architecture;
import com.aliyun.app.dao.dict.LanguageType;
import com.aliyun.app.dao.dict.OsType;
import com.aliyun.app.dao.dict.PlatForm;
import com.aliyun.app.dao.dict.SourceSystemOssChecksumType;
import com.aliyun.app.dao.dict.TargetImageFormat;
import com.aliyun.app.dao.dict.TaskStatus;
import com.aliyun.app.dao.dict.TaskType;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by wangxiaosan on 16/11/10.
 */
public class TasksDO {
    /**
     * create table if not exists tasks(
     id bigint auto_increment not null,
     createTime timestamp default current_timestamp,

     -- API public params
     appKey varchar(128) not null,
     appSecret varchar(128) not null,
     sign varchar(128) not null,
     requestId varchar(128) not null,
     clientToken varchar(128) not null,

     -- API params related
     taskType enum('make', 'check', 'convert') not null, -- make/check/convert
     regionId varchar(128) not null, -- region ID
     imageId varchar(128) not null, -- yaochi defined image ID
     osType enum('windows', 'linux') not null, -- windows/linux, default linux
     language enum('Chinese', 'English', 'Japanese') default "English",
     architecture enum('x86_64', 'i386') not null,
     platform enum(
     -- windows
     'windows-7',
     'windows-10',
     'windows-Server-2008',
     'windows-Server-2012',
     -- linux
     'aliyun-linux',
     'centos',
     'coreos',
     'customized-linux',
     'debian',
     'opensuse',
     'redhat',
     'suse',
     'ubuntu',
     'freebsd') not null,
     version varchar(16) not null, -- OS version, i.e., for centos, this is 6.8, 7.2 ...
     patch boolean default false, -- under windows, upadate windows or not
     systemDiskFormat varchar(16) default "raw", -- raw/vhd
     systemDiskSize bigint default 42949672960, -- 40GB
     ossBucket varchar(32) not null, -- oss bucket name
     sourceSystemOssObject varchar(1024) not null, -- oss object (iso/vhd) path
     sourceSystemOssChecksum varchar(128) not null, -- oss object (iso/vhd) path
     sourceSystemOssChecksumType enum('md5', 'sha128') default "md5", -- oss object (iso/vhd) path
     userDefinedScriptOssObject varchar(1024) not null, -- oss object(xxx.sh) path
     scriptRelatedFileOssObject varchar(1024) not null, -- oss object path
     autoRepair boolean default true, -- if any error within image, repaire them
     targetImageFormat enum('raw', 'vhd') default "raw",
     sourceImageOssBucket varchar(32) not null,
     sourceImageOssObject varchar(1024) not null,
     sourceImageOssChecksum varchar(128) not null, -- oss object (iso/vhd) path
     sourceImageOssChecksumType enum('md5', 'sha128') default "md5", -- oss object (iso/vhd) path

     -- Packer generated file
     packerOutFileName varchar(128) default null, -- Packer generated image sit under a file server
     packerOutFileSize bigint default 0,
     packerOutFileMd5 varchar(32) default null,
     packerOutFileDownloadedOk boolean default false,


     -- API resp related
     taskId varchar(128) not null, -- generated task ID after API request
     errorCode varchar(64) default null, -- API request error code
     resultIamgeOssBucket varchar(32) not null,
     resultIamgeOssObject varchar(1024) not null,

     --
     -- task running status
     --

     -- timestamp related
     startTime int(64) not null,
     endTime int(64) not null,
     lastUpdateTime int(0) not null, -- each step will update the task status

     -- stauts/steps/progress related
     status enum('Finished', 'Processing', 'Pending', 'Deleted', 'Paused', 'Timeout') default "Pending",
     currentStepId varchar(128) not null,
     totalSteps int not null,
     remainingSteps int not null,

     nodeId varchar(256) default null, -- each node have a KVM and a XEN NC

     -- kvm/xen related --
     kvmEnabled boolean default true, -- does KVM enabled for the task
     kvmTaskAvailable boolean default false,
     kvmDone boolean default false,
     kvmNcIp varchar(256) default null, -- which NC is running this KVM task

     xenEnabled boolean default true, -- does XEN enabled for the task
     xenTaskAvailable boolean default false,
     xenDone boolean default false,
     xenNcIp varchar(256) default null, -- which NC is running this XEN task

     primary key(id),
     unique key idxTaskId(taskId)) character set utf8;
     */

    private Long id;
    private Date createTime;
    private String appKey;
    private String appSecret;
    private String sign;
    private String requestId;
    private String clientToken;
    private TaskType taskType;
    private String regionId;
    private String imageId;
    private OsType osType;
    private LanguageType language;
    private Architecture architecture;
    private String platform;
    private Long version;
    private Boolean patch;
    private String systemDiskFormat;
    private Long systemDiskSize;
    private String ossBucket;
    private String sourceSystemOssObject;
    private String sourceSystemOssChecksum;
    private SourceSystemOssChecksumType sourceSystemOssChecksumType;
    private String userDefinedScriptOssObject;
    private String scriptRelatedFileOssObject;
    private Boolean autoRepair;
    private TargetImageFormat targetImageFormat;
    private String sourceImageOssBucket;
    private String sourceImageOssObject;
    private String sourceImageOssChecksum;
    private SourceSystemOssChecksumType sourceImageOssChecksumType;

    private String packerOutFileName;
    private Long packerOutFileSize;
    private String packerOutFileMd5;
    private Boolean packerOutFileDownloadedOk;


    private String taskId;
    private String errorCode;
    private String resultIamgeOssBucket;
    private String resultIamgeOssObject;

    private int startTime;
    private int endTime;
    private int lastUpdateTime;

    private TaskStatus status;
    private String currentStepId;
    private Integer totalSteps;
    private Integer remainingSteps;

    private String nodeId;

    private Boolean kvmEnabled;
    private Boolean kvmTaskAvailable;
    private Boolean kvmDone;
    private String kvmNcIp;

    private Boolean xenEnabled;
    private Boolean xenTaskAvailable;
    private Boolean xenDone;
    private String xenNcIp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getClientToken() {
        return clientToken;
    }

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public OsType getOsType() {
        return osType;
    }

    public void setOsType(OsType osType) {
        this.osType = osType;
    }

    public LanguageType getLanguage() {
        return language;
    }

    public void setLanguage(LanguageType language) {
        this.language = language;
    }

    public Architecture getArchitecture() {
        return architecture;
    }

    public void setArchitecture(Architecture architecture) {
        this.architecture = architecture;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Boolean getPatch() {
        return patch;
    }

    public void setPatch(Boolean patch) {
        this.patch = patch;
    }

    public String getSystemDiskFormat() {
        return systemDiskFormat;
    }

    public void setSystemDiskFormat(String systemDiskFormat) {
        this.systemDiskFormat = systemDiskFormat;
    }

    public Long getSystemDiskSize() {
        return systemDiskSize;
    }

    public void setSystemDiskSize(Long systemDiskSize) {
        this.systemDiskSize = systemDiskSize;
    }

    public String getOssBucket() {
        return ossBucket;
    }

    public void setOssBucket(String ossBucket) {
        this.ossBucket = ossBucket;
    }

    public String getSourceSystemOssObject() {
        return sourceSystemOssObject;
    }

    public void setSourceSystemOssObject(String sourceSystemOssObject) {
        this.sourceSystemOssObject = sourceSystemOssObject;
    }

    public String getSourceSystemOssChecksum() {
        return sourceSystemOssChecksum;
    }

    public void setSourceSystemOssChecksum(String sourceSystemOssChecksum) {
        this.sourceSystemOssChecksum = sourceSystemOssChecksum;
    }

    public SourceSystemOssChecksumType getSourceSystemOssChecksumType() {
        return sourceSystemOssChecksumType;
    }

    public void setSourceSystemOssChecksumType(SourceSystemOssChecksumType sourceSystemOssChecksumType) {
        this.sourceSystemOssChecksumType = sourceSystemOssChecksumType;
    }

    public String getUserDefinedScriptOssObject() {
        return userDefinedScriptOssObject;
    }

    public void setUserDefinedScriptOssObject(String userDefinedScriptOssObject) {
        this.userDefinedScriptOssObject = userDefinedScriptOssObject;
    }

    public String getScriptRelatedFileOssObject() {
        return scriptRelatedFileOssObject;
    }

    public void setScriptRelatedFileOssObject(String scriptRelatedFileOssObject) {
        this.scriptRelatedFileOssObject = scriptRelatedFileOssObject;
    }

    public Boolean getAutoRepair() {
        return autoRepair;
    }

    public void setAutoRepair(Boolean autoRepair) {
        this.autoRepair = autoRepair;
    }

    public TargetImageFormat getTargetImageFormat() {
        return targetImageFormat;
    }

    public void setTargetImageFormat(TargetImageFormat targetImageFormat) {
        this.targetImageFormat = targetImageFormat;
    }

    public String getSourceImageOssBucket() {
        return sourceImageOssBucket;
    }

    public void setSourceImageOssBucket(String sourceImageOssBucket) {
        this.sourceImageOssBucket = sourceImageOssBucket;
    }

    public String getSourceImageOssObject() {
        return sourceImageOssObject;
    }

    public void setSourceImageOssObject(String sourceImageOssObject) {
        this.sourceImageOssObject = sourceImageOssObject;
    }

    public String getSourceImageOssChecksum() {
        return sourceImageOssChecksum;
    }

    public void setSourceImageOssChecksum(String sourceImageOssChecksum) {
        this.sourceImageOssChecksum = sourceImageOssChecksum;
    }

    public SourceSystemOssChecksumType getSourceImageOssChecksumType() {
        return sourceImageOssChecksumType;
    }

    public void setSourceImageOssChecksumType(SourceSystemOssChecksumType sourceImageOssChecksumType) {
        this.sourceImageOssChecksumType = sourceImageOssChecksumType;
    }

    public String getPackerOutFileName() {
        return packerOutFileName;
    }

    public void setPackerOutFileName(String packerOutFileName) {
        this.packerOutFileName = packerOutFileName;
    }

    public Long getPackerOutFileSize() {
        return packerOutFileSize;
    }

    public void setPackerOutFileSize(Long packerOutFileSize) {
        this.packerOutFileSize = packerOutFileSize;
    }

    public String getPackerOutFileMd5() {
        return packerOutFileMd5;
    }

    public void setPackerOutFileMd5(String packerOutFileMd5) {
        this.packerOutFileMd5 = packerOutFileMd5;
    }

    public Boolean getPackerOutFileDownloadedOk() {
        return packerOutFileDownloadedOk;
    }

    public void setPackerOutFileDownloadedOk(Boolean packerOutFileDownloadedOk) {
        this.packerOutFileDownloadedOk = packerOutFileDownloadedOk;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getResultIamgeOssBucket() {
        return resultIamgeOssBucket;
    }

    public void setResultIamgeOssBucket(String resultIamgeOssBucket) {
        this.resultIamgeOssBucket = resultIamgeOssBucket;
    }

    public String getResultIamgeOssObject() {
        return resultIamgeOssObject;
    }

    public void setResultIamgeOssObject(String resultIamgeOssObject) {
        this.resultIamgeOssObject = resultIamgeOssObject;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(int lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getCurrentStepId() {
        return currentStepId;
    }

    public void setCurrentStepId(String currentStepId) {
        this.currentStepId = currentStepId;
    }

    public Integer getTotalSteps() {
        return totalSteps;
    }

    public void setTotalSteps(Integer totalSteps) {
        this.totalSteps = totalSteps;
    }

    public Integer getRemainingSteps() {
        return remainingSteps;
    }

    public void setRemainingSteps(Integer remainingSteps) {
        this.remainingSteps = remainingSteps;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Boolean getKvmEnabled() {
        return kvmEnabled;
    }

    public void setKvmEnabled(Boolean kvmEnabled) {
        this.kvmEnabled = kvmEnabled;
    }

    public Boolean getKvmTaskAvailable() {
        return kvmTaskAvailable;
    }

    public void setKvmTaskAvailable(Boolean kvmTaskAvailable) {
        this.kvmTaskAvailable = kvmTaskAvailable;
    }

    public Boolean getKvmDone() {
        return kvmDone;
    }

    public void setKvmDone(Boolean kvmDone) {
        this.kvmDone = kvmDone;
    }

    public String getKvmNcIp() {
        return kvmNcIp;
    }

    public void setKvmNcIp(String kvmNcIp) {
        this.kvmNcIp = kvmNcIp;
    }

    public Boolean getXenEnabled() {
        return xenEnabled;
    }

    public void setXenEnabled(Boolean xenEnabled) {
        this.xenEnabled = xenEnabled;
    }

    public Boolean getXenTaskAvailable() {
        return xenTaskAvailable;
    }

    public void setXenTaskAvailable(Boolean xenTaskAvailable) {
        this.xenTaskAvailable = xenTaskAvailable;
    }

    public Boolean getXenDone() {
        return xenDone;
    }

    public void setXenDone(Boolean xenDone) {
        this.xenDone = xenDone;
    }

    public String getXenNcIp() {
        return xenNcIp;
    }

    public void setXenNcIp(String xenNcIp) {
        this.xenNcIp = xenNcIp;
    }
}
