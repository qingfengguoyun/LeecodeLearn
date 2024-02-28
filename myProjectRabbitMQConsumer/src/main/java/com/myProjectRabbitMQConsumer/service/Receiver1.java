package com.myProjectRabbitMQConsumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(queues = "topic.red")
public class Receiver1 {

    @RabbitHandler
    public void process(String s){
        log.info("topic.red通道: 消费成功"+s);
    }
}
