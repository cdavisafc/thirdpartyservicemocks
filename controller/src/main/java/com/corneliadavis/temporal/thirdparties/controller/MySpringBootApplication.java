package com.corneliadavis.temporal.thirdparties.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = { "com.corneliadavis.temporal.*" })
@EntityScan("com.corneliadavis.temporal.*")
public class MySpringBootApplication {

	public static void main(String[] args) { SpringApplication.run(MySpringBootApplication.class, args); }
}
