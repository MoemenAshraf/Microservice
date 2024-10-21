package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class Main {
    public static void main(String[] args) {
        // Start the Spring Boot application and load the application context
        ApplicationContext context = SpringApplication.run(Main.class, args);

        // Notification - You can log something after application startup
        System.out.println("Product Service is up and running!");
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
