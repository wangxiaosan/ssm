package com.aliyun.app.dao.dict;

/**
 * Created by wangxiaosan on 16/11/10.
 */
public enum PlatForm {
    windows7("windows-7"),windows10("windows-10"),windowsServer08("windows-Server-2008"),
    windowsServer12("windows-Server-2012"),aliyunLinux("aliyun-linux"),centos("centos"),coreos("coreos"),
    cuntomizedLisnux("customized-linux"),
    debian("debian"),opensuse("opensuse"),redhat("redhat"),suse("suse"),ubuntu("ubuntu"),freebsd("freebsd");

    private String value;


    PlatForm(String value) {

        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
