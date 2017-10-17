package com.wwy.app.model.dict;

import static java.util.Objects.nonNull;

/**
 * Created by wangxiaosan on 16/11/10.
 */
public enum TargetImageFormat {
    /**
     * 目标镜像格式化raw
     */
    raw,
    /**
     * 目标镜像格式化vhd
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
