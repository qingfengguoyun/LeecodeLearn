package com.myProjectRabbitMQLearn.rabbitMq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 简易发送消息
     */
    public void send(){
        String context="hello "+ new Date();
        log.info("sender:发送消息"+context);
        this.rabbitTemplate.convertAndSend("hello",context);
    }

    /**
     * 通过交换机exchange使用topic匹配发送消息
     */
    public void send1(){
        String context="topic.red";
        rabbitTemplate.convertAndSend("exchange","topic.red",context);
    }
    public void send2(){
        String context="topic.blue";
        rabbitTemplate.convertAndSend("exchange","topic.blue",context);
    }
    public void sendAll(){
        String context="topic.#";
        rabbitTemplate.convertAndSend("exchange","topic",context);
    }

    /**
     * 通过myFanout广播向所有绑定的通道发送消息
     */
    public void sendF(){
        String context="topic.fanout";
        rabbitTemplate.convertAndSend("myFanout","",context);
    }

}
