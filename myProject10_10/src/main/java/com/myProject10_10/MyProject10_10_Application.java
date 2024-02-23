package com.myProject10_10;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableAsync
@EnableScheduling
@MapperScan("com.myProject10_10.dao")
public class MyProject10_10_Application {
    public static void main(String[] args) {
        SpringApplication.run(MyProject10_10_Application.class,args);
    }
}
