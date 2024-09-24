package com.vaccine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringvaccineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringvaccineApplication.class, args);

		try {
			// Load MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			System.out.println("Connection established successfully.");
		} catch (Exception e) {
			// Handle all exceptions in a single catch block
			System.out.println("Error loading MySQL JDBC Driver: " + e.toString());
		}

	}

}
