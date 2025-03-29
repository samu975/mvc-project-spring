package com.rollerspeed.rollerspeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.rollerspeed.rollerspeed"})
public class RollerspeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(RollerspeedApplication.class, args);
	}

}
