package com.example.reserve_manage_app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.reserve_manage_app.mapper")
public class ReserveManageAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReserveManageAppApplication.class, args);
	}

}
