package com.eirunye.defpropertys.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author YRG
 * Created by on 2018/8/20.
 * Describe
 */

@RestController
public class DefPropertyController {

    @Value("${com.eirunye.defproname}")
    private String defProName;

    @Value("${com.eirunye.defpropass}")
    private String defProPass;

    @RequestMapping(value = "/defproprety")
    public String defPropretyUser() {
        return "这个自定义属性名为: " + defProName + ", 密码为:" + defProPass;
    }
}
