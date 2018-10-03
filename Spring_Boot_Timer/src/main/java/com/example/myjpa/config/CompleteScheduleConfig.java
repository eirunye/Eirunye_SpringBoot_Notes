package com.example.myjpa.config;

import com.example.myjpa.model.Student;
import com.example.myjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.FixedDelayTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.time.LocalDateTime;

/**
 * Author YRG
 * Created by on 2018/7/19.
 * Describe
 */
@Configuration
@EnableScheduling
public class CompleteScheduleConfig implements SchedulingConfigurer {

    @Autowired
    StudentRepository studentRepository;
    private static String DEFAULT_CRON = "0 0/2 * * * ?";//表示间隔2分钟

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {


//        scheduledTaskRegistrar.scheduleFixedDelayTask(new FixedDelayTask(() -> {
//
//        }, 10000, 1000 * 60));

        scheduledTaskRegistrar.addTriggerTask(() -> {
            Student student = new Student();
        
            student.setName("ok");
            student.setAge(12);
            student.setSex("nan");
            studentRepository.save(student);
            System.out.println("===插入成功!===");
        }, triggerContext -> {
            return new CronTrigger(DEFAULT_CRON).nextExecutionTime(triggerContext);
        });


    }


}
