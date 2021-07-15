package com.tech.interview.siply.redbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RedbusApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedbusApplication.class, args);
    }

}
