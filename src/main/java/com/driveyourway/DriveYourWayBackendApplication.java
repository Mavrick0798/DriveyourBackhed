package com.driveyourway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DriveYourWayBackendApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.location", "application.properties");
		SpringApplication.run(DriveYourWayBackendApplication.class, args);
	}

}
