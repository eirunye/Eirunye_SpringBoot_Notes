package com.eirunye.spring_boot_jpa.bean;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * Author Eirunye
 * Created by on 2018/9/28.
 * Describe
 */
@Entity
@Table(name = "user",catalog = "")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username",columnDefinition = "VARCHAR(50) NOT NULL COMMENT '用户名不为空!'",unique = true)
    @NotBlank(message = "username can't be null")
    private String username;

    @Column(name = "password",columnDefinition = "VARCHAR(50) NOT NULL COMMENT '密码不为空!'")
    @NotBlank(message = "password can't be null")
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_time", columnDefinition = "datetime DEFAULT NULL COMMENT '创建时间'")
    private Date createTime; //创建时间

    @Temporal(TemporalType.DATE)
    @Column(name = "update_time", columnDefinition = "datetime DEFAULT NULL COMMENT '更新时间'")
    private Date updateTime;//更新时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
