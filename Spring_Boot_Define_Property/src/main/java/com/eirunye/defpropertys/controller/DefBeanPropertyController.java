package com.eirunye.defpropertys.controller;

import com.eirunye.defpropertys.bean.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author YRG
 * Created by on 2018/8/20.
 * Describe
 */
@RestController
public class DefBeanPropertyController {
//    通过 Autowired注解来获取到 Properties属性，注:Autowired是按类型进行装配，可获取它所装配类的属性
    @Autowired
    Properties properties;

    @RequestMapping(value = "/bean/defproperty")
    public String getDefBeanProperties() {
        return "这是通过Bean注解的方式获取属性: " + properties.getDefproname() + ",密码为: " + properties.getDefpropass();
    }
}
