package com.david.makson.coffe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = "com.david.makson.coffe")
public class InitApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitApplication.class, args);
	}
	
}

