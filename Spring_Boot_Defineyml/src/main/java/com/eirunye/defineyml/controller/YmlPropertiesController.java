package com.eirunye.defineyml.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author YRG
 * Created by on 2018/8/20.
 * Describe Value获取的Controller
 */
@RestController
public class YmlPropertiesController {

    @Value("${com.eirunye.ymlname}")
    private String ymlname;

    @Value("${com.eirunye.ymlpass}")
    private String ymlpass;

    @RequestMapping(value = "yml/proprety")
    public String getYmlPropreties() {
        return "这个自定义属性名为: " + ymlname+ ", 密码为:" + ymlpass;
    }

}
