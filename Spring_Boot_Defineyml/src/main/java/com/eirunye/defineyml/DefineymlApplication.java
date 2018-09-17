package com.eirunye.defineyml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({com.eirunye.defineyml.bean.YmlPropertyBean.class,com.eirunye.defineyml.bean.YmlDefBean.class})
public class DefineymlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DefineymlApplication.class, args);
	}
}
