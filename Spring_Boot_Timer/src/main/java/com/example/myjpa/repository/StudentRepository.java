package com.example.myjpa.repository;

import com.example.myjpa.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author YRG
 * Created by on 2018/7/19.
 * Describe
 */
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {

//    @Insert("INSERT INTO student (name,age,sex) SELECT #{name},#{age},#{sex} from student where not exists (SELECT\n" +
//            "        name,age,sex\n" +
//            "    FROM\n" +
//            "        student\n" +
//            "    where \n" +
//            "#{name},#{age},#{sex})")
//    int insert(@Param("name") String name, @Param("age") Integer age, @Param("sex") String sex);

}
