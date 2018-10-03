package com.example.myjpa.service;

import com.example.myjpa.dao.StudentMapper;
import com.example.myjpa.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Author YRG
 * Created by on 2018/7/19.
 * Describe
 */

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public int saveStudent(Student student) {
        System.out.println("保存数据开始");
//        student.setName("小美眉");
//        student.setAge(18);
//        student.setSex("hh");
//        studentMapper.insertOne("hh",12,"nan");
        return studentMapper.saveStudent(student);

    }

    @Override
    public Student selectUserById(int id) {
        return studentMapper.selectUserById(id);
    }

    @Override
    public int insert1(String name, Integer age, String sex) {
        int i = studentMapper.insert1(name, age, sex);
        return i;
    }


}
