package com.myProjectSocketIoPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MyProjectSocketPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyProjectSocketPracticeApplication.class,args);
    }
}
