package com.mousa.demo.RefineryDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RefineryDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RefineryDemoApplication.class, args);
	}

}
