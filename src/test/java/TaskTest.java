import com.aliyun.app.dao.TaskDao;
import com.aliyun.app.dao.dict.Architecture;
import com.aliyun.app.dao.dict.LanguageType;
import com.aliyun.app.dao.dict.OsType;
import com.aliyun.app.dao.dict.PlatForm;
import com.aliyun.app.dao.dict.TargetImageFormat;
import com.aliyun.app.dao.dict.TaskType;
import com.aliyun.app.dao.entity.TasksDO;
import com.aliyun.app.service.StepsService;
import com.aliyun.app.ws.dto.request.MakeRequestDto;
import com.aliyun.app.ws.dto.response.CheckTaskResponseDto;
import com.aliyun.app.ws.dto.response.MakeResponseDto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

import static com.aliyun.app.service.impl.DefaultStepsService.getUUID;
import static org.apache.commons.lang.StringUtils.isBlank;

/**
 * Created by wangxiaosan on 16/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class TaskTest {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private StepsService stepsService;

    @Test
    public void daoMakeTaskTest(){
        TasksDO tasksDO = new TasksDO();
        tasksDO.setRegionId("regionId");
        tasksDO.setImageId("imageId");
        tasksDO.setArchitecture(Architecture.i386);
        tasksDO.setOsType(OsType.linux);
        tasksDO.setLanguage(LanguageType.Chinese);
        tasksDO.setPlatform(PlatForm.windows7.getValue());
        tasksDO.setPatch(Boolean.TRUE);
        tasksDO.setSystemDiskFormat("raw");
        tasksDO.setSystemDiskSize(128L);
        tasksDO.setOssBucket("ossBucket");
        tasksDO.setSourceSystemOssObject("sourceSystemOssObject");
        tasksDO.setUserDefinedScriptOssObject("userDefinedScriptOSSObject");
        tasksDO.setScriptRelatedFileOssObject(".zip");


        tasksDO.setAppKey(getUUID());
        tasksDO.setAppSecret(getUUID());
        tasksDO.setSign(getUUID());
        tasksDO.setRequestId(getUUID());
        tasksDO.setClientToken(getUUID());
        tasksDO.setVersion(0L);
        tasksDO.setSourceSystemOssChecksum("");
        tasksDO.setSourceImageOssBucket("");
        tasksDO.setSourceImageOssObject("");
        tasksDO.setSourceImageOssChecksum("");
        tasksDO.setTaskId(getUUID());
        tasksDO.setResultIamgeOssBucket("");
        tasksDO.setResultIamgeOssObject("");
        tasksDO.setStartTime(LocalDateTime.now().getSecond());
        tasksDO.setEndTime(LocalDateTime.now().getSecond());
        tasksDO.setLastUpdateTime(LocalDateTime.now().getSecond());
        tasksDO.setCurrentStepId(getUUID());
        tasksDO.setTotalSteps(0);
        tasksDO.setRemainingSteps(0);
        Long id = taskDao.makeTask(tasksDO);
        System.out.println(id);
    }

    @Test
    public void DaoFindTask(){
        MakeResponseDto dto = taskDao.findTask(17L);
        System.out.println(dto.getTaskId()+"******"+dto.getTaskType());
    }

    @Test
    public void DaoCheckTask(){
        TasksDO tasksDO = new TasksDO();
        tasksDO.setRegionId("regionId");
        tasksDO.setImageId("imageId");
        tasksDO.setTaskType(TaskType.check);
        tasksDO.setArchitecture(Architecture.i386);
        tasksDO.setOsType(OsType.linux);
        tasksDO.setPlatform(PlatForm.aliyunLinux.getValue());
        tasksDO.setTargetImageFormat(TargetImageFormat.raw);
        tasksDO.setAutoRepair(Boolean.TRUE);
        //TODO configCheckItems
        //格式如：{enable:"",disable:""},enable与disable分别代表需要检测与跳过的配置项集合，可以单独配置或者为空
        tasksDO.setSourceImageOssBucket("");
        tasksDO.setSourceImageOssObject("");
        tasksDO.setOssBucket("");
        tasksDO.setSourceSystemOssObject("");
        tasksDO.setUserDefinedScriptOssObject("");
        tasksDO.setScriptRelatedFileOssObject("");

        tasksDO.setAppKey(getUUID());
        tasksDO.setAppSecret(getUUID());
        tasksDO.setSign(getUUID());
        tasksDO.setRequestId(getUUID());
        tasksDO.setClientToken(getUUID());
        tasksDO.setVersion(0L);
        tasksDO.setSourceSystemOssChecksum("");
        tasksDO.setSourceImageOssChecksum("");
        tasksDO.setTaskId(getUUID());
        tasksDO.setResultIamgeOssBucket("");
        tasksDO.setResultIamgeOssObject("");
        tasksDO.setStartTime(0);
        tasksDO.setEndTime(0);
        tasksDO.setLastUpdateTime(0);
        tasksDO.setCurrentStepId("");
        tasksDO.setTotalSteps(0);
        tasksDO.setRemainingSteps(0);
        Long id = taskDao.makeTask(tasksDO);
        System.out.println(id);
    }

    @Test
    public void DaoFindCheckTask(){
        CheckTaskResponseDto dto = taskDao.findCheckTask(17L);
        System.out.println(dto.getTaskId()+"******"+dto.getTaskType());
    }

    @Test
    public void serviceMakeTask(){
        MakeResponseDto responseDto = new MakeResponseDto();
        MakeRequestDto dto = new MakeRequestDto();
        dto.setRegionId("regionId");
        dto.setImageId("imageId");
        dto.setArchitecture(Architecture.i386.name());
        dto.setOsType(OsType.linux.name());
        dto.setOsLanguage(LanguageType.Chinese.name());
        dto.setPlatform("windows7");
        dto.setPatch("true");
        dto.setSystemDiskFormat("raw");
        dto.setSystemDiskSize("128");
        dto.setOssBucket("ossBucket");
        dto.setSourceSystemOSSObject("sourceSystemOssObject");
        dto.setUserDefinedScriptOSSObject("userDefinedScriptOSSObject");
        dto.setScriptRelatedFileOSSObject(".zip");
        stepsService.makeTask(responseDto,dto);
        System.out.println(responseDto.getTaskId()+"******"+responseDto.getTaskType());
    }
}
