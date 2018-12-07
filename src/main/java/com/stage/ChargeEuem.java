package com.stage;

/**
 * @Auther: 张扬
 * @Date: 2018/9/28 16:13
 * @Description:
 */
public enum ChargeEuem {
    GENNERAL("普通用户",200),
    VIP("VIP用户",100);

    private String euemName;
    private Integer value;

    public String getEuemName() {
        return euemName;
    }
    ChargeEuem(String euemName,Integer value){
        this.euemName= euemName;
        this.value= value;
    }
    public void setEuemName(String euemName) {
        this.euemName = euemName;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
