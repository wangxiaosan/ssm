package com.wwy.app.model.dict;

import static java.util.Objects.nonNull;

/**
 * Created by wangxiaosan on 16/11/10.
 */
public enum Architecture {
    /**
     * architecture amd64
     */
    amd64,
    /**
     * architecture i386
     */
    i386;

    public static Architecture byCode(final String code) {
        for (Architecture type : Architecture.values()) {
            if (type.name().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public static boolean isExist(String code) {
        Architecture type = byCode(code);
        return nonNull(type);
    }
}
