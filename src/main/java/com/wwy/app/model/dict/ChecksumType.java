package com.wwy.app.model.dict;

import static java.util.Objects.nonNull;

/**
 * Created by wangxiaosan on 16/11/22.
 */
public enum ChecksumType {
    /**
     * type md5
     */
    md5,
    /**
     * type sha128
     */
    sha128;

    public static ChecksumType byCode(final String code) {
        for (ChecksumType type : ChecksumType.values()) {
            if (type.name().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public static boolean isExist(String code) {
        ChecksumType type = byCode(code);
        return nonNull(type);
    }
}
