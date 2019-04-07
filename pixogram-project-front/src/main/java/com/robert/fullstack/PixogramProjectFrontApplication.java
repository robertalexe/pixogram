package com.robert.fullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableZuulProxy
@EnableEurekaClient
public class PixogramProjectFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixogramProjectFrontApplication.class, args);
	}

}
