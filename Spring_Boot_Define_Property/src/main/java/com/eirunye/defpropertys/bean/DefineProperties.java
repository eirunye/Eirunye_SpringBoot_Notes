package com.eirunye.defpropertys.bean;

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
@ConfigurationProperties(prefix = "com.eirunye")//添加注解 ConfigurationProperties "com.eirunye"表示的是自定义属性
@PropertySource("classpath:defines.properties")// 添加注解 PropertySource 该注解能根据路径扫描到我们的文件
public class DefineProperties {
//    这里可以通过@Value("${}")方式添加,我已经屏蔽掉了，直接通过ConfigurationProperties注解的方式
//    @Value("${com.eirunye.defineuser}")
    private String defineuser;
//    @Value("${com.eirunye.defineage}")
    private int defineage;
// get/set方法
    public String getDefineuser() {
        return defineuser;
    }

    public void setDefineuser(String defineuser) {
        this.defineuser = defineuser;
    }

    public int getDefineage() {
        return defineage;
    }

    public void setDefineage(int defineage) {
        this.defineage = defineage;
    }
}
