package com.eirunye.defineyml.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author YRG
 * Created by on 2018/8/20.
 * Describe
 */
@ConfigurationProperties(prefix = "com.eirunye")//添加该注解
public class YmlPropertyBean {

    private String ymlname;

    private String ymlpass;

    public String getYmlname() {
        return ymlname;
    }

    public void setYmlname(String ymlname) {
        this.ymlname = ymlname;
    }

    public String getYmlpass() {
        return ymlpass;
    }

    public void setYmlpass(String ymlpass) {
        this.ymlpass = ymlpass;
    }

}
