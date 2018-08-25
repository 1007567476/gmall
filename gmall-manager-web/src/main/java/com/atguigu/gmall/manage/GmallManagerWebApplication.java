package com.atguigu.gmall.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.atguigu.gmall")
public class GmallManagerWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmallManagerWebApplication.class, args);
	}
}
