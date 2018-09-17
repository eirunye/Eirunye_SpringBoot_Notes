package com.eirunye.defineyml.controller;

import com.eirunye.defineyml.bean.YmlPropertyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author YRG
 * Created by on 2018/8/20.
 * Describe 创建Bean对应的Controller
 */
@RestController
public class YmlPropertyBeanController {

    @Autowired
    YmlPropertyBean propertyBean;

    @RequestMapping(value = "/bean/ymlproperty")
    public String getYmlPropertyData(){
        return "这个bean自定义属性名为: " + propertyBean.getYmlname()+ ", 密码为:" + propertyBean.getYmlpass();
    }
}
