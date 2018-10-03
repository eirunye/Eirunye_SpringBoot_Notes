package com.example.myjpa.service;

import com.example.myjpa.model.Student;
import com.example.myjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author YRG
 * Created by on 2018/7/19.
 * Describe
 */
@Configuration //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling // 2.开启定时任务
public class ScheduledTasks {


    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //    @Scheduled(cron = "0/5 * * * * ?")
//    @Scheduled(fixedRate = 1000 * 60)
    @Scheduled(cron = "0 0/2 * * * ?")
    public void configureTasks() {
        System.out.println("The time is now " + dateFormat.format(new Date()));

    }
}
