package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Marks this class as the main entry point of the Spring Boot application
@SpringBootApplication // Enables auto-configuration, component scanning, and Spring Boot features
public class MainApp {
	public static void main(String[] args) {
		// Launches the Spring Boot application
		SpringApplication.run(MainApp.class, args);
	}
}