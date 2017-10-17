package com.wwy.app.model.dict;

import static java.util.Objects.nonNull;

public enum StorageType {
    /**
     * 存储类型oss
     */
    oss,
    /**
     * 存储类型http
     */
    http,
    /**
     * 存储类型disk
     */
    disk,
    /**
     * 存储类型tdc
     */
    tdc;

    public static StorageType byCode(final String code) {
        for (StorageType type : StorageType.values()) {
            if (type.name().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public static boolean isExist(String code) {
        StorageType type = byCode(code);
        return nonNull(type);
    }
}
