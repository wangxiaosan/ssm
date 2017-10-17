package com.wwy.app.model.dict;

import static java.util.Objects.nonNull;

/**
 * Created by wangxiaosan on 16/11/10.
 */
public enum TaskType {
    /**
     * 任务操作类型-make
     */
    make,
    /**
     * 任务操作类型-check
     */
    check;

    public static TaskType byCode(final String code) {
        for (TaskType type : TaskType.values()) {
            if (type.name().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public static boolean isExist(String code) {
        TaskType type = byCode(code);
        return nonNull(type);
    }
}
