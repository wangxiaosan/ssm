package com.wwy.app.model.dict;

import static java.util.Objects.nonNull;

/**
 * Created by wangxiaosan on 16/11/10.
 */
public enum LanguageType {
    /**
     * 中文
     */
    Chinese,
    /**
     * 英文
     */
    English,
    /**
     * 日文
     */
    Japanese;

    public static LanguageType byCode(final String code) {
        for (LanguageType type : LanguageType.values()) {
            if (type.name().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public static boolean isExist(String code) {
        LanguageType type = byCode(code);
        return nonNull(type);
    }
}
