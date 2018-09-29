package com.eirunye.spring_boot_jpa.service;

import com.eirunye.spring_boot_jpa.bean.Result;
import com.eirunye.spring_boot_jpa.bean.User;
import com.eirunye.spring_boot_jpa.enums.ResultEnum;
import com.eirunye.spring_boot_jpa.exception.EirunyeException;
import com.eirunye.spring_boot_jpa.repository.UserRepository;
import com.eirunye.spring_boot_jpa.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author Eirunye
 * Created by on 2018/9/29.
 * Describe
 */
@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    /**
     * 插入数据
     *
     * @param user 用户
     * @return Json user
     * @throws Exception 异常抛出
     */
    public Result<User> saveUserData(User user) throws Exception {

        User user1 = userRepository.save(user);

        return ResultUtil.getResult(ResultEnum.SUCCESS, user1);
    }

    /**
     * 根据id来获取user信息
     *
     * @param id 参数id
     * @return Json user
     */
    public Result<User> getUserDataById(Integer id) throws Exception {

        User user = userRepository.findAllById(id);
        if (null == user) {
            throw new EirunyeException(ResultEnum.USERNOTEXIST);//用户不存在
        } else
            return ResultUtil.getResult(ResultEnum.SUCCESS, user);
    }

    /**
     * 更新user信息 更新数据说明：
     * 1.如果通过save(S s)方法的话必须带主键Id，这样通过主键id就能更新数据了，
     * 如果不带参数id则，数据将会自增一条数据（变成插入数据了）
     * 2.自定义SQL语句更新数据（后面会讲到）
     *
     * @param user 参数user
     * @return json String
     */
    public Result<String> updateUserInfo(User user) throws Exception {


        if (null == user.getId()) return ResultUtil.error(-1, "Id不能为空!");
        //更新数据
        User userUpdate = userRepository.save(user);
        if (userUpdate == null) return ResultUtil.error(-1, "数据更新失败,请联系后台!");

        // 一般更新数据步骤：
        // 1.通过ID获取当前用户信息
        // 2.将所需更新的信息进行设置，如用户名、密码等，而创建时间不需要更新
        // 3.如果没有其他特殊字段直接save方法更新(注：这里我就简单直接save了，大家的项目应该是下面这样方式写)
        //User userInfo = userRepository.findAllById(user.getId());
        //userInfo.setId(user.getId());
        //userInfo.setUsername(user.getUsername());
        //userInfo.setPassword(user.getPassword());
        //userInfo.setUpdateTime(new Date());
        //userInfo.setCreateTime(new Date()); //这个不需要设置

        return ResultUtil.getResult(ResultEnum.SUCCESS, "更新数据成功!!!");
    }

    /**
     * @param id 参数id
     * @return json String
     */
    public Result<String> deleteUserInfo(Integer id) throws Exception {

        userRepository.deleteById(id);

        //下面不需要也可以，直接返回return ResultUtil.getResult(ResultEnum.SUCCESS, "删除数据成功!!!");
        User user = userRepository.findAllById(id);
        if (null == user) {
            throw new EirunyeException(ResultEnum.SUCCESS);
        } else return ResultUtil.error(-1, "删除数据失败!!!");
    }

    /**
     * 模糊查询user
     * @param username 参数用户名
     * @return
     * @throws Exception
     */
    public Result<List<User>> findListUserData(String username) throws Exception {
        return ResultUtil.getResult(ResultEnum.SUCCESS, userRepository.findAllByUsername(username));
    }


}
