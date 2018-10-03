package com.example.myjpa.controller;

import com.example.myjpa.model.Student;
import com.example.myjpa.repository.StudentRepository;
import com.example.myjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Author YRG
 * Created by on 2018/7/19.
 * Describe
 */
@RestController
@Transactional
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;
//
//    @PostMapping(value = "/insert/student")
//    public int insertStudent(@Valid Student student) {
//
////        int i = studentRepository.insert(student.getName(), student.getAge(), student.getSex());
//        return 0;
//    }

    @PostMapping(value = "save/student")
    public int saveStudent(@Valid Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping(value = "get/student/{id}")
    public Student getStudents(@PathVariable int id) {
        return studentService.selectUserById(id);
    }

//    @PostMapping(value = "/insert/student")
//    public int insertStudents(@Valid Student student) {
//        return studentService.insert1(student.getName(), student.getAge(), student.getSex());
//    }
}
