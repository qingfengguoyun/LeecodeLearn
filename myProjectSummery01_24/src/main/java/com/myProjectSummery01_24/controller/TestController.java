package com.myProjectSummery01_24.controller;

import com.myProjectSummery01_24.annotations.MyAnnotation1;
import com.myProjectSummery01_24.entity.User;
import com.myProjectSummery01_24.service.RedisCacheService;
import com.myProjectSummery01_24.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class TestController {

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    RedisCacheService redisCacheService;

    @GetMapping("/redisTest")
    public void redisTest(){
        User asd = User.Builder().id(1).userName("asd").build();
        redisUtils.setCacheObject("user",asd);
        List<User> userList=new LinkedList<>();
        for(int i=0;i<5;i++){
            User user = User.Builder().id(i).userName("name" + i).build();
            userList.add(user);
        }
        redisUtils.setCacheList("userList",userList);
    }

    @GetMapping("/redisTestShow")
    public void redisTestShow(){
        List<Object> userName = redisUtils.getCacheList("userList");
        userName.stream().forEach(t->{
            log.info(t.toString());
        });
        Object user = redisUtils.getCacheObject("user");
        log.info(user.toString());
    }

    @GetMapping("/redisClean")
    public void redisTestClean(){
        redisUtils.clearDatabase();
    }

    @MyAnnotation1
    @GetMapping("/redisCache/{id}")
    public void redisCahce(@PathVariable Integer id){
        String s = redisCacheService.redisCacheTest(id);

    }
}
