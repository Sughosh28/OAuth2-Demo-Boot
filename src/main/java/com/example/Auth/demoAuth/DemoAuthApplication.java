package com.example.Auth.demoAuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class DemoAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAuthApplication.class, args);
	}

}
