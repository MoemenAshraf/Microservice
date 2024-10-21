package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // Start the Spring Boot application and load the application context
        ApplicationContext context = SpringApplication.run(Main.class, args);

        // Notification - You can log something after application startup
        System.out.println("Order Service is up and running!");
    }
}
