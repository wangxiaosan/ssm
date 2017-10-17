package com.wwy.app.model.dict;

import static java.util.Objects.nonNull;

/**
 * Created by wangxiaosan on 16/12/25.
 */
public enum SystemDiskFormat {
    /**
     * 系统盘格式化 raw
     */
    raw,
    /**
     * 系统盘格式化 vhd
     */
    vhd;

    public static TargetImageFormat byCode(final String code) {
        for (TargetImageFormat type : TargetImageFormat.values()) {
            if (type.name().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public static boolean isExist(String code) {
        TargetImageFormat type = byCode(code);
        return nonNull(type);
    }
}
