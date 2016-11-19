package com.aliyun.app.dao.dict;

import static java.util.Objects.nonNull;

/**
 * Created by wangxiaosan on 16/11/10.
 */
public enum OsType {
    windows,
    linux;

    public static OsType byCode(final String code) {
        for (OsType type : OsType.values()) {
            if(type.name().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public static boolean isExist(String code) {
        OsType type = byCode(code);
        return (nonNull(type)) ? true : false;
    }
}
