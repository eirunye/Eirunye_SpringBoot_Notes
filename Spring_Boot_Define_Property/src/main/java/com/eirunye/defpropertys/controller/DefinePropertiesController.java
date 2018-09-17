package com.eirunye.defpropertys.controller;

import com.eirunye.defpropertys.bean.DefineProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author YRG
 * Created by on 2018/8/20.
 * Describe
 */
@RestController
public class DefinePropertiesController {

    @Autowired
    DefineProperties defineProperties;

    @RequestMapping(value = "define/Properties")
    public String getDefinePropertiesData(){
        return "新建文件自定义属性姓名："+defineProperties.getDefineuser()+",新建文件自定义属性年龄："+defineProperties.getDefineage();
    }
}
