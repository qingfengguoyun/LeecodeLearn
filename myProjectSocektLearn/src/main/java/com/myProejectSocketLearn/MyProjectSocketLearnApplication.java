package com.myProejectSocketLearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableCaching
@EnableWebSocket
public class MyProjectSocketLearnApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyProjectSocketLearnApplication.class,args);
    }
}
