package com.eirunye.spring_boot_jpa.controller;

import com.eirunye.spring_boot_jpa.bean.Result;
import com.eirunye.spring_boot_jpa.bean.User;
import com.eirunye.spring_boot_jpa.enums.ResultEnum;
import com.eirunye.spring_boot_jpa.exception.EirunyeException;
import com.eirunye.spring_boot_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Author Eirunye
 * Created by on 2018/9/28.
 * Describe
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 通过id查找user信息
     *
     * @param id 参数id
     * @return 返回Json user
     * @throws Exception
     */
    @GetMapping(value = "/info/{id}")
    public Result<User> getUserDataById(@PathVariable Integer id) throws Exception {

        if (null == id) throw new EirunyeException(ResultEnum.UNKNOWN_ERROR);//这里定义自己的提示错误信息,最好每个都有定义这样比较明确错误!!!

        return userService.getUserDataById(id);
    }


    /**
     * 插入数据
     *
     * @param user 用户信息
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/info/save")
    public Result<User> saveUserData(@Valid User user) throws Exception {

        if (null == user) throw new EirunyeException(ResultEnum.UNKNOWN_ERROR);//这里定义自己的提示错误信息,最好每个都有定义这样比较明确错误!!!

        return userService.saveUserData(user);
    }


    /**
     * 更新user信息
     *
     * @param user 参数
     * @return 返回提示 更新失败或者成功
     * @throws Exception 异常
     */
    @PostMapping(value = "/info/update")
    public Result<String> updateUserInfo(@Valid User user) throws Exception {

        if (null == user) throw new EirunyeException(ResultEnum.UNKNOWN_ERROR);

        return userService.updateUserInfo(user);
    }

    /**
     * 通过ID参数user信息
     *
     * @param id 参数id
     * @return 返回提示 参数成功或者失败
     */
    @GetMapping(value = "/info/delete/{id}")
    public Result<String> deleteUserInfo(@PathVariable Integer id) throws Exception {
        if (null == id) throw new EirunyeException(ResultEnum.UNKNOWN_ERROR);

        return userService.deleteUserInfo(id);
    }

    @RequestMapping(value = "/info/list/{username}")
    public Result<List<User>> findListUserData(@PathVariable String username) throws Exception {

        if ("".equals(username) || null == username) throw new EirunyeException(ResultEnum.UNKNOWN_ERROR);

        return userService.findListUserData(username);
    }


}
