/******************************************/
/*   数据库全名 = image_factory   */
/*   表名称 = check_results   */
/******************************************/
CREATE TABLE `check_results` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `task_id` varchar(255) DEFAULT NULL COMMENT 'task id',
    `ok` int(11) DEFAULT NULL COMMENT '是否检测成功',
    `info` varchar(1024) DEFAULT NULL COMMENT '检测成功信息',
    `warn` varchar(1024) DEFAULT NULL COMMENT '检测警告信息',
    `err` varchar(1024) DEFAULT NULL COMMENT '检测错误信息',
    `item_name` varchar(255) DEFAULT NULL COMMENT '检测项名称',
    `item_desc` varchar(255) DEFAULT NULL COMMENT '检测项描述',
    `item_label` varchar(255) DEFAULT NULL COMMENT '检测项标签',
    `failed_result` varchar(255) DEFAULT NULL COMMENT '检测项如果失败的具体影响',
    `is_fix_enabled` tinyint(1) unsigned DEFAULT '1' COMMENT '是否修复',
    `is_fix_ok` tinyint(1) unsigned DEFAULT '1' COMMENT '修复是否成功',
    `fix_info` varchar(255) DEFAULT NULL COMMENT '修复结果信息',
    `is_interrupted` tinyint(1) unsigned DEFAULT '1' COMMENT '是否被中断',
    `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
    `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`),
    KEY `idx_check_results_task_id` (`task_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=515 DEFAULT CHARSET=utf8 COMMENT='检测结果表'
;

/******************************************/
/*   数据库全名 = image_factory   */
/*   表名称 = tasks   */
/******************************************/
CREATE TABLE `tasks` (
    `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `gmt_modify` datetime DEFAULT NULL COMMENT '修改时间',
    `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
    `app_key` varchar(255) NOT NULL COMMENT '授权key',
    `app_secret` varchar(255) NOT NULL COMMENT '授权secret',
    `sign` varchar(255) NOT NULL,
    `request_id` varchar(255) NOT NULL COMMENT 'trace id\n',
    `client_token` varchar(255) NOT NULL COMMENT 'client token',
    `region_id` varchar(255) NOT NULL COMMENT 'region no',
    `image_id` varchar(255) NOT NULL COMMENT 'image id',
    `task_type` varchar(255) NOT NULL COMMENT '任务类型',
    `os_type` varchar(255) DEFAULT 'linux' COMMENT 'windows, linux',
    `language` varchar(255) DEFAULT 'English' COMMENT '操作系统语言',
    `architecture` varchar(255) DEFAULT 'amd64' COMMENT '32/64 bit 平台',
    `platform` varchar(255) NOT NULL COMMENT '支持的操作系统列表',
    `version` varchar(255) DEFAULT NULL COMMENT '操作系统版本',
    `is_make_done` tinyint(1) unsigned DEFAULT '0' COMMENT '是否制作完成',
    `system_disk_size` bigint(20) unsigned DEFAULT NULL COMMENT '镜像系统盘大小',
    `storage_type` varchar(255) DEFAULT 'oss' COMMENT '镜像文件存放方式',
    `storage_url` varchar(255) NOT NULL COMMENT '镜像文件地址',
    `storage_checksum` varchar(255) DEFAULT NULL COMMENT '镜像文件校验码',
    `storage_checksum_type` varchar(255) DEFAULT 'md5' COMMENT '校验方式',
    `oss_bucket` varchar(255) NOT NULL COMMENT 'OSS 存放 bucket',
    `user_defined_script_url` varchar(255) DEFAULT NULL COMMENT ' 用户自定义脚本地址',
    `script_related_file_url` varchar(255) DEFAULT NULL COMMENT '用户自定义文件地址',
    `is_auto_repair` tinyint(1) unsigned DEFAULT '1' COMMENT '检测过程中是否自动修复',
    `is_install_windows_update` tinyint(1) unsigned DEFAULT '0' COMMENT '是否安装 Windows 更新',
    `target_image_format` varchar(255) DEFAULT 'raw' COMMENT '目标镜像格式',
    `system_disk_format` varchar(255) DEFAULT 'raw' COMMENT '原始镜像格式',
    `disabled_check_items` varchar(255) DEFAULT NULL COMMENT '禁用的检测项列表',
    `disabled_fix_items` varchar(255) DEFAULT NULL COMMENT '禁用的修复列表',
    `check_timeout` int(11) DEFAULT NULL COMMENT '镜像检测超时时间',
    `make_timeout` int(11) DEFAULT NULL COMMENT '镜像制作超时时间',
    `is_img_ready` tinyint(1) unsigned DEFAULT '0' COMMENT '镜像文件是否就绪',
    `is_xen_download_img_ok` tinyint(1) unsigned DEFAULT '0' COMMENT 'xen 是否下载镜像完成',
    `task_id` varchar(255) DEFAULT NULL COMMENT '任务 UUID',
    `result_image_oss_bucket` varchar(255) DEFAULT NULL COMMENT '目标镜像存放的 OSS bucket',
    `result_image_oss_object` varchar(255) DEFAULT NULL COMMENT '目标镜像存放的 OSS 对象地址',
    `is_support_cancel` tinyint(1) unsigned DEFAULT '1' COMMENT '是否支持取消',
    `start_time` bigint(20) DEFAULT NULL COMMENT '任务开始时间',
    `progress` varchar(8) DEFAULT NULL COMMENT '进度',
    `expected_time` bigint(20) DEFAULT NULL COMMENT '期望结束时间',
    `finished_time` bigint(20) DEFAULT NULL COMMENT '任务结束时间',
    `status` varchar(255) NOT NULL DEFAULT 'Pending' COMMENT '任务状态',
    `node_id` varchar(255) DEFAULT NULL COMMENT '领取该任务的工作节点 UUID',
    `is_kvm_enabled` tinyint(1) unsigned DEFAULT '1' COMMENT 'kvm 是否开启',
    `is_kvm_done` tinyint(1) unsigned DEFAULT '0' COMMENT 'kvm 是否完成',
    `kvm_nc_ip` varchar(255) DEFAULT NULL COMMENT 'kvm 的 NC IP',
    `is_xen_enabled` tinyint(1) unsigned DEFAULT '1' COMMENT ' xen 是否开启',
    `is_xen_done` tinyint(1) unsigned DEFAULT '0' COMMENT 'xen 是否完成',
    `xen_nc_ip` varchar(255) DEFAULT NULL COMMENT 'xen NC IP',
    `error_msg` varchar(255) DEFAULT NULL COMMENT '错误信息',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uix_tasks_task_id` (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='检测等任务表'
;

