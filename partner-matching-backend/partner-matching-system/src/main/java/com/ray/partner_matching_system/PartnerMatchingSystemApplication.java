package com.ray.partner_matching_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.ray.partner_matching_system.mapper")
@EnableScheduling
public class PartnerMatchingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartnerMatchingSystemApplication.class, args);
	}

}
