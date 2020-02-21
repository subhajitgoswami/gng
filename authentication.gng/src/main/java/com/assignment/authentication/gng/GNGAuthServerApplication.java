package com.assignment.authentication.gng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAuthorizationServer
public class GNGAuthServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GNGAuthServerApplication.class, args);
	}
}
