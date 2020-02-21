package com.assignment.resource.gng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableResourceServer
public class GNGResourceServerApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(GNGResourceServerApplication.class, args);
    }
}


