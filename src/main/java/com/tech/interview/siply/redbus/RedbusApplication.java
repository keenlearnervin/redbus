package com.tech.interview.siply.redbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RedbusApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedbusApplication.class, args);
    }
}
