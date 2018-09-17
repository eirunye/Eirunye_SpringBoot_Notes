package com.eirunye.defineyml.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Author YRG
 * Created by on 2018/8/20.
 * Describe
 */
@Configuration
@ConfigurationProperties(prefix = "eiyml")//添加注解 ConfigurationProperties "com.eirunye"表示的是自定义属性
//@PropertySource("classpath:appdefines.yml")// 添加注解 PropertySource 该注解能根据路径扫描到我们的文件
public class YmlDefBean {

//    @Value("${eirunye.ymluser}")
    private String ymluser;

    private String ymlpass;

    public String getYmluser() {
        return ymluser;
    }

    public void setYmluser(String ymluser) {
        this.ymluser = ymluser;
    }

    public String getYmlpass() {
        return ymlpass;
    }

    public void setYmlpass(String ymlpass) {
        this.ymlpass = ymlpass;
    }
}
