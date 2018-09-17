package com.eirunye.defpropertys.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author YRG
 * Created by on 2018/8/20.
 * Describe
 */
@ConfigurationProperties(prefix = "com.eirunye")//添加该注解
public class Properties {

    private String defproname;

    private String defpropass;
//  get/set方法
    public String getDefproname() {
        return defproname;
    }

    public void setDefproname(String defproname) {
        this.defproname = defproname;
    }

    public String getDefpropass() {
        return defpropass;
    }

    public void setDefpropass(String defpropass) {
        this.defpropass = defpropass;
    }
}
