package com.eirunye.defineyml.controller;

import com.eirunye.defineyml.bean.YmlDefBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author YRG
 * Created by on 2018/8/20.
 * Describe 新创建define.yml对应的controller
 */
@RestController
public class YmlDefProController {

    @Autowired
    YmlDefBean ymlDefBean;

    @RequestMapping(value = "/ymldef/property")
    public String getYmlDefBeanData() {
        return "通过新建.yml文件获取用户名:" + ymlDefBean.getYmluser() + ",密码: " + ymlDefBean.getYmlpass();
    }
}
