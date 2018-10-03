package com.example.myjpa.service;

import com.example.myjpa.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * Author YRG
 * Created by on 2018/7/19.
 * Describe
 */
public interface StudentService {

    int saveStudent(Student student);

    Student selectUserById(int id);

    //    @Insert("INSERT INTO student(name, age,sex) VALUES(#{name}, #{age},#{sex})")
    int insert1(String name, Integer age, String sex);

}
