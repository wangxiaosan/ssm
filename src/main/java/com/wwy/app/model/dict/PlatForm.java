package com.wwy.app.model.dict;

import static java.util.Objects.nonNull;

/**
 * Created by wangxiaosan on 16/11/10.
 */
public enum PlatForm {
    /**
     * win7平台
     */
    windows7("Windows7"), /**
     * win10平台
     */
    windows10("Windows10"), /**
     * winServer2008平台
     */
    windowsServer08("WindowsServer2008R2"), /**
     * winServer2012平台
     */
    windowsServer12("WindowsServer2012R2"), /**
     * winServer2016平台
     */
    windowsServer16("WindowsServer2016"),/**
     * aliyunLinux平台
     */
    aliyunLinux("Aliyun-linux"), /**
     * centos平台
     */
    centos("Centos"), /**
     * coreos平台
     */
    coreos("Coreos"), /**
     * cuttomizedLinux平台
     */
    customizedLinux("Customized-linux"), /**
     * debian平台
     */
    debian("Debian"), /**
     * opensuse平台
     */
    opensuse("Opensuse"), /**
     * redhat平台
     */
    redhat("Redhat"), /**
     * suse平台
     */
    suse("Suse"), /**
     * fedora平台
     */
    fedora("Fedora"), /**
     * ubuntu平台
     */
    ubuntu("Ubuntu"), /**
     * freebsd平台
     */
    freebsd("Freebsd");

    private String value;

    PlatForm(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PlatForm byCode(final String value) {
        for (PlatForm type : PlatForm.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return null;
    }

    public static boolean isExist(String code) {
        PlatForm type = byCode(code);
        return nonNull(type);
    }

    public static PlatForm getPlatForm(String value) {
        return byCode(value);
    }
}
