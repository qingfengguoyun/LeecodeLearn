package com.myProjectRabbitMQLearn.controller;

import com.myProjectRabbitMQLearn.rabbitMq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private Sender sender;

    @GetMapping("/send")
    public void testSend(){
        sender.send();
    }

    @GetMapping("/send1")
    public void testSend1(){
        sender.send1();
    }

    @GetMapping("/send2")
    public void testSend2(){
        sender.send2();
    }

    @GetMapping("/sendAll")
    public void testSendAll(){
        sender.sendAll();
    }

    @GetMapping("/sendf")
    public void testSendF(){
        sender.sendF();
    }
}
