package com.robert.fullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class PixogramProjectFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixogramProjectFrontApplication.class, args);
	}

}
