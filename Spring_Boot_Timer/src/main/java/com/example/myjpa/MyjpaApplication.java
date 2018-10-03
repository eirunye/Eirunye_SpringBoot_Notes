package com.example.myjpa;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.myjpa.dao")
@EnableScheduling
public class MyjpaApplication {

	public static void main(String[] args) {
        SpringApplication.run(MyjpaApplication.class, args);
	}
}
