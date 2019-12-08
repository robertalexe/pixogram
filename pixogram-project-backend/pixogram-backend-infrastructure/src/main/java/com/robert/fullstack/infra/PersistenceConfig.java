package com.robert.fullstack.infra;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.robert.fullstack.infra")
@EntityScan(
        basePackages = {"com.robert.fullstack", "org.springframework.data.jpa.convert.threeten"}
)
@ComponentScan(
        basePackages = {"com.robert.fullstack"}
)
@EnableAutoConfiguration
public class PersistenceConfig {
}
