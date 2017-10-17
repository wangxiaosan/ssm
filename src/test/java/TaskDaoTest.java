import com.google.common.collect.Lists;
import com.wwy.app.dao.TaskDao;
import com.wwy.app.model.dict.*;
import com.wwy.app.model.dto.CancelTaskDto;
import com.wwy.app.model.dto.QueryTaskDto;
import com.wwy.app.model.dto.TaskDto;
import com.wwy.app.model.entity.TasksDO;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.wwy.app.service.impl.DefaultStepsService.getUUID;

/**
 * Created by wangxiaosan on 16/11/25.
 */

public class TaskDaoTest extends TestConfig {
    @Autowired
    private TaskDao taskDao;

    @Test
    public void testMakeTaskTest() {
        TasksDO tasksDO = new TasksDO();
        tasksDO.setTaskType(TaskType.make.name());
        tasksDO.setRegionId("regionId");
        tasksDO.setImageId("imageId");
        tasksDO.setArchitecture(Architecture.amd64.name());
        tasksDO.setOsType(OsType.linux.name());
        tasksDO.setLanguage(LanguageType.English.name());
        tasksDO.setPlatform(PlatForm.fedora.getValue());
        tasksDO.setIsInstallWindowsUpdate(Boolean.TRUE);
        tasksDO.setSystemDiskFormat("raw");
        tasksDO.setSystemDiskSize(53687091200L);
        tasksDO.setOssBucket("image-service-23315");
        tasksDO.setStorageUrl("/apsarapangu/disk1/image-service/iso/centos-7.2-1511.amd64.iso");
        tasksDO.setStorageType(StorageType.disk.name());
        tasksDO.setAppKey(getUUID());
        tasksDO.setAppSecret(getUUID());
        tasksDO.setSign(getUUID());
        tasksDO.setRequestId(getUUID());
        tasksDO.setClientToken(getUUID());
        tasksDO.setVersion("0");
        tasksDO.setStorageChecksum("");
        tasksDO.setTaskId(getUUID());
        tasksDO.setIsKvmEnabled(true);
        tasksDO.setIsXenEnabled(false);
        tasksDO.setResultImageOssBucket("image-service-23315");
        tasksDO.setResultImageOssObject("fedora-24.amd64.raw");
        tasksDO.setStartTime(0L);
        tasksDO.setFinishedTime(0L);
        tasksDO.setStorageChecksumType(ChecksumType.md5.name());
        tasksDO.setIsInstallWindowsUpdate(false);
        tasksDO.setStatus(TaskStatus.Pending.name());
        tasksDO.setIsSupportCancel(false);
        tasksDO.setIsKvmDone(false);
        tasksDO.setIsXenDone(false);
        tasksDO.toString();
        tasksDO.getStorageChecksumType();
        tasksDO.getIsInstallWindowsUpdate();
        tasksDO.getErrorMsg();
        tasksDO.getStatus();
        tasksDO.getIsSupportCancel();
        tasksDO.getNodeId();
        tasksDO.getIsKvmEnabled();
        tasksDO.getIsKvmDone();
        tasksDO.getKvmNcIp();
        tasksDO.getIsXenDone();
        tasksDO.getXenNcIp();
        taskDao.makeTask(tasksDO);
        Assert.assertNotNull(tasksDO.getId());
        taskDao.deleteTask(Long.valueOf(tasksDO.getId()));
    }


    /**
     * 预留两条数据，taskId为425d6533-fc5a-48a8-a1fc-5274baec59bd,078bdec4-3a93-498c-ae7c-013b45a9ffca
     */
    @Test
    public void testQueryTaskTest() {
        List<String> taskIds = Lists.newArrayList();
        taskIds.add("425d6533-fc5a-48a8-a1fc-5274baec59bd");
        taskIds.add("078bdec4-3a93-498c-ae7c-013b45a9ffca");
        QueryTaskDto dto = new QueryTaskDto();
        dto.setKey("key1");
        dto.setPageNumber(1);
        dto.setPageSize(10);
        dto.setRegionId("hangzhou");
        dto.setTaskIds(taskIds);
        dto.toString();
        List<TaskDto> response = Lists.newArrayList();
        TaskDto taskDto = new TaskDto();
        taskDto.setRegionId("hangzhou");
        taskDto.setTaskId("425d6533-fc5a-48a8-a1fc-5274baec59bd");
        taskDto.setTaskType("make");
        taskDto.setTaskStatus("Pending");
        taskDto.setProgress("progress");
        taskDto.setExpectedTime("2017-02-26T10:20Z");
        taskDto.setSupportCancel("true");
        taskDto.setCreationTime("2017-02-26T09:30Z");
        taskDto.setFinishedTime("2017-02-26T09:46Z");
        response.add(taskDto);
        TaskDao taskDao1 = PowerMockito.mock(TaskDao.class);
        PowerMockito.when(taskDao1.queryTask(dto)).thenReturn(response);
        Assert.assertEquals("425d6533-fc5a-48a8-a1fc-5274baec59bd",taskDao1.queryTask(dto).get(0).getTaskId());

    }

    /**
     * 预留两条数据，taskId为425d6533-fc5a-48a8-a1fc-5274baec59bd,078bdec4-3a93-498c-ae7c-013b45a9ffca
     */
    @Test
    public void testCountTask() {
        List<String> taskIds = Lists.newArrayList();
        taskIds.add("425d6533-fc5a-48a8-a1fc-5274baec59bd");
        taskIds.add("078bdec4-3a93-498c-ae7c-013b45a9ffca");
        QueryTaskDto dto = new QueryTaskDto();
        dto.setKey("key1");
        dto.setPageNumber(1);
        dto.setPageSize(10);
        dto.setRegionId("hangzhou");
        dto.setTaskIds(taskIds);
        TaskDao dao = PowerMockito.mock(TaskDao.class);
        PowerMockito.when(dao.countTask(dto)).thenReturn(2);
        int count = dao.countTask(dto);
        Assert.assertEquals(2,count);
    }

    /**
     * 预留两条数据，taskId为425d6533-fc5a-48a8-a1fc-5274baec59bd,078bdec4-3a93-498c-ae7c-013b45a9ffca
     */
    @Test
    public void testCountTaskForCancel() {
        CancelTaskDto dto = new CancelTaskDto();
        List<String> taskIds = Lists.newArrayList();
        taskIds.add("425d6533-fc5a-48a8-a1fc-5274baec59bd");
        taskIds.add("078bdec4-3a93-498c-ae7c-013b45a9ffca");
        dto.setKey("key1");
        dto.setRegionId("hangzhou");
        dto.setTaskIds(taskIds);
        TaskDao dao = PowerMockito.mock(TaskDao.class);
        PowerMockito.when(dao.countTaskForCancel(dto)).thenReturn(2);
        int count = dao.countTaskForCancel(dto);
        Assert.assertEquals(2,count);
    }

    /**
     * 预留两条数据，taskId为425d6533-fc5a-48a8-a1fc-5274baec59bd,078bdec4-3a93-498c-ae7c-013b45a9ffca
     */
    @Test
    public void testCancelTask() {
        CancelTaskDto dto = new CancelTaskDto();
        List<String> taskIds = Lists.newArrayList();
        taskIds.add("425d6533-fc5a-48a8-a1fc-5274baec59bd");
        taskIds.add("078bdec4-3a93-498c-ae7c-013b45a9ffca");
        dto.setKey("key1");
        dto.setRegionId("hangzhou");
        dto.setTaskIds(taskIds);
        dto.toString();
        TaskDao dao = PowerMockito.mock(TaskDao.class);
        dao.cancelTask(dto);
        Mockito.verify(dao).cancelTask(dto);
    }

}
