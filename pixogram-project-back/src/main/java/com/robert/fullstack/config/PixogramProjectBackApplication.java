package com.robert.fullstack.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan( basePackages = {"com.robert.fullstack"})
@EnableTransactionManagement
@EnableJpaRepositories("com.robert.fullstack")
@EntityScan(basePackages = {"com.robert.fullstack"})
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class PixogramProjectBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixogramProjectBackApplication.class, args);
	}

}
