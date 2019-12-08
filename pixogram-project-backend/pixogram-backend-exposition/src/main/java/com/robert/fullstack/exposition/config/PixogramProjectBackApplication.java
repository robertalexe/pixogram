package com.robert.fullstack.exposition.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan( basePackages = {"com.robert.fullstack"})
@EnableTransactionManagement
@EntityScan(basePackages = {"com.robert.fullstack"})
@EnableEurekaClient
public class PixogramProjectBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixogramProjectBackApplication.class, args);
	}

}
