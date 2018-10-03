package com.example.myjpa;

import com.example.myjpa.model.Moan;
import com.example.myjpa.model.Student;
import com.example.myjpa.repository.MoanRepository;
import com.example.myjpa.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyjpaApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    MoanRepository moanRepository;

    @Test
    public void saveMoan() {
//        new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//                for (int i = 0; i < 10; i++) {
//                    Moan moan = new Moan();
//                    if (i % 3 == 0) {
//                        moan.setUser("user");
//                    } else {
//                        moan.setUser("user" + i);
//                    }
//                    moan.setPassword("12345");
//                    moan.setUid(UUID.randomUUID().toString());
//                    moanRepository.save(moan);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }).start();

        for (int i = 0; i < 10; i++) {
            Moan moan = new Moan();
            if (i % 3 == 0) {
                moan.setUser("user");
            } else {
                moan.setUser("user" + i);
            }
            moan.setPassword("12345");
            moan.setUid(UUID.randomUUID().toString());
            moanRepository.save(moan);
        }

    }

    @Autowired
    private StudentService studentService;
    @Test
    public void saveStudent(){
        studentService.saveStudent(new Student());
    }

}
