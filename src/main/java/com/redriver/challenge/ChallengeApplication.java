package com.redriver.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@ComponentScan(basePackages = "com.redriver.challenge.controller")
@EnableJpaRepositories(basePackages = "com.redriver.challenge.repository")
@SpringBootApplication

public class ChallengeApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }

}
