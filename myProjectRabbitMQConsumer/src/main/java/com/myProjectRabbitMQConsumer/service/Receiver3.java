package com.myProjectRabbitMQConsumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(queues = "topic.all")
public class Receiver3 {

    @RabbitHandler
    public void process(String s){
        log.info("topic.all通道: 消费成功"+s);
    }
}
