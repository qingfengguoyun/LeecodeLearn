package com.myProjectSummery01_24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableCaching
@EnableAspectJAutoProxy
public class MyProjectSummery01_24_Application {

    public static void main(String[] args) {
        SpringApplication.run(MyProjectSummery01_24_Application.class,args);
    }
}
