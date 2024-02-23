package com.myProjectRabbitMQConsumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queuesToDeclare = @Queue("hello"))
@Slf4j
public class MesssageConsumeService {

    @RabbitHandler
    public void process(String s){
        log.info("receiver1: 消费成功"+s);
    }
}
