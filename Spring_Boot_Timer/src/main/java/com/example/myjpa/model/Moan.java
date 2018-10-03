package com.example.myjpa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Author YRG
 * Created by on 2018/7/18.
 * Describe
 */
@Entity
@Table(name = "moan", uniqueConstraints = {@UniqueConstraint(columnNames = {"user"})})
public class Moan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "user不能为空!")
    @Column(name = "user", unique = true)
    private String user;


    private String password;


    private String uid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
