package com.example.myjpa.dao;

import com.example.myjpa.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Author YRG
 * Created by on 2018/7/19.
 * Describe
 */
@Mapper
public interface StudentMapper {

    int saveStudent(Student student);

    Student selectUserById(int id);

    @Insert("INSERT INTO student (name,age,sex) VALUES (#{name},#{age},#{sex})\n" +
            "ON DUPLICATE KEY UPDATE")
    int insertStudent(@Param("name") String name, @Param("age") Integer age, @Param("sex") String sex);

    @Insert("INSERT INTO student (name,age,sex) SELECT #{name},#{age},#{sex} from dual where not exists (SELECT\n" +
            "        name,age,sex\n" +
            "    FROM\n" +
            "        student\n" +
            "    where \n" +
            "#{name},#{age},#{sex})")
    int insertOne(@Param("name") String name, @Param("age") Integer age, @Param("sex") String sex);


    int insert1( String name,Integer age, String sex);
}
