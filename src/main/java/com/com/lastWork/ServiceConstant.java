package com.com.lastWork;

public enum ServiceConstant {
    APP_ID("应用唯一ID(系统分配)","ydfx"),
    DES_KEY("DES加解密密钥","&jp(5$s@");
    private String name;
    private String key;

    ServiceConstant(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
