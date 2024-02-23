package com.myProject9_21.controller;

import com.myProject9_21.entity.MyEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {
    @GetMapping("/login")
    public String login(){

        System.out.println("login 测试");
        MyEntity myEntity=new MyEntity.Builder().str("123").number(12).build();
        System.out.println(myEntity.toString());
        return "login";
    }
}
