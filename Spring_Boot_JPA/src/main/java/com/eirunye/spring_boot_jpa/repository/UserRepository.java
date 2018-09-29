package com.eirunye.spring_boot_jpa.repository;

import com.eirunye.spring_boot_jpa.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Author Eirunye
 * Created by on 2018/9/29.
 * Describe
 * 提示：这里需要注意的是命名规则 查找find，删除delete等等
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * @param id 根据id获取当前user数据
     * @return user
     */
    User findAllById(Integer id);

    /**
     * 通过用户名和密码来获取用户
     * @param username 参数用户名
     * @param password 参数密码
     * @return 返回user
     */
    User findAllByUsernameAndPassword(String username, String password);


    /**
     * 模糊查询 自定义查询语句
     * @param username
     * @return
     */
    @Query(value = "select * from user u where u.username like %:username%",nativeQuery=true)
    List<User> findAllByUsername(@Param("username") String username);


    @Modifying
    @Transactional
    @Query(value = "insert into user(username,password,create_time,update_time) values(?1,?2,?3,?4)",nativeQuery = true)
    int findAllByUsernameAndPasswordAndCreateTimeAndUpdateTime(String username, String password, Date create_time,Date update_time);


}
