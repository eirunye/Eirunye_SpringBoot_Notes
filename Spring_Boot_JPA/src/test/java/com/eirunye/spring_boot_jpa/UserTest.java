package com.eirunye.spring_boot_jpa;

import com.eirunye.spring_boot_jpa.bean.Result;
import com.eirunye.spring_boot_jpa.bean.User;
import com.eirunye.spring_boot_jpa.handle.ExceptionHandle;
import com.eirunye.spring_boot_jpa.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Author Eirunye
 * Created by on 2018/9/29.
 * Describe 测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);


    @Autowired
    UserService userService;

    @Test
    public void getUserInfo() throws Exception {
        Result<User> userDataById = userService.getUserDataById(1);
        logger.info(userDataById.getData().toString());
        System.out.println(userDataById.getData().toString());
    }

    @Test
    public void saveUserInfo() throws Exception {
        User user = new User();
        user.setUsername("Eirunye");
        user.setPassword("123456");
        user.setCreateTime(new Date());//这里只做测试用，一般都是后台处理时间
        user.setUpdateTime(new Date());//这里只做测试用，一般都是后台处理时间

        System.out.println(user.toString());
        Result<User> userResult = userService.saveUserData(user);
        System.out.println(userResult);
    }

    @Test
    public void updateUserInfo() throws Exception {
        User user = new User();
        user.setId(1);//JPA更新数据要添加主键ID，如果不加就相当于插入一条新数据
        user.setUsername("Eirunye");
        user.setPassword("123456789");
//        user.setCreateTime(new Date());创建时间不需要添加，这里一般都是后台处理
        user.setUpdateTime(new Date());//这里只做测试用，一般都是后台处理时间
        System.out.println(user.toString());
        Result<String> userResult = userService.updateUserInfo(user);
        System.out.println(userResult.getData());
    }

    @Test
    public void updateUserInfo1() throws Exception {
        User user = new User();
//        user.setId(1);//JPA更新数据要添加主键ID，如果不加就相当于插入一条新数据
        user.setUsername("Eirunye");
        user.setPassword("123456789");
        user.setUpdateTime(new Date());//这里只做测试用，一般都是后台处理时间
        System.out.println(user.toString());
        Result<String> userResult = userService.updateUserInfo(user);
        System.out.println(userResult.getData());
    }


    @Test
    public void deleteUserInfo() throws Exception {
        Result<String> stringResult = userService.deleteUserInfo(1);
        System.out.println(stringResult.getData());
    }


}
