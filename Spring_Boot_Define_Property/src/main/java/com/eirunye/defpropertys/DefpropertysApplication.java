package com.eirunye.defpropertys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({com.eirunye.defpropertys.bean.Properties.class, com.eirunye.defpropertys.bean.DefineProperties.class})//添加注解bean的扫描文件
public class DefpropertysApplication {

    public static void main(String[] args) {
        SpringApplication.run(DefpropertysApplication.class, args);
    }
}
