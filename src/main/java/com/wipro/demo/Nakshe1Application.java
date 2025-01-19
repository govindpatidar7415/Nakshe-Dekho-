package com.wipro.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.ecom.model") // Your entity package
@EnableJpaRepositories(basePackages = "com.wipro.demo.repository") // Your repository package
@ComponentScan(basePackages = {"com.wipro.demo", "com.ecom"," com.ecom.util"}) // Ensure scanning of SecurityConfig
public class Nakshe1Application {

    public static void main(String[] args) {
        SpringApplication.run(Nakshe1Application.class, args);
    }
}
