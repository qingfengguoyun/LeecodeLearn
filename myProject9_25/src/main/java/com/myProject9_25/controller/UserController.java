package com.myProject9_25.controller;

import com.myProject9_25.entity.User;
import com.myProject9_25.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUserById")
    public void getUserById(Long id){
        User user=userService.getUserById(id);
        System.out.println(user.toString());
    }

    @GetMapping("/insertUserTest")
    public void insertUser(){
        for(int i=0;i<10;i++){
            User user=new User.Builder().userName("丽华"+i).password("123456").build();
            userService.insertUser(user);
        }
    }

    @GetMapping("/getUserLikeName")
    public void getUserLikeName(String userName){
        List<User> users=userService.queryUserLikeName(userName);
        users.forEach(user->{
            System.out.println(user);
        });
    }
}
