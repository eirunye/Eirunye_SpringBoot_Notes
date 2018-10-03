package com.example.myjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Author YRG
 * Created by on 2018/7/19.
 * Describe
 */
@Entity
public class Student {


    @Id
    @GeneratedValue
    private Integer id;
    //    @Column(name = "name", unique = true)
    private String name;
    private int age;
    private String sex;

    public Student() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
