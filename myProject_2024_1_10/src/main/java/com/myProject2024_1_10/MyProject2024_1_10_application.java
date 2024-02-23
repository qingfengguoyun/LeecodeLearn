package com.myProject2024_1_10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MyProject2024_1_10_application {
    public static void main(String[] args) {
        SpringApplication.run(MyProject2024_1_10_application.class,args);
    }
}
