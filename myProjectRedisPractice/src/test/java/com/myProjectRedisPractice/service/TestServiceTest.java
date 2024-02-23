package com.myProjectRedisPractice.service;

import com.myProjectRedisPractice.entity.User;
import com.myProjectRedisPractice.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TestServiceTest {

    @Autowired
    TestService testService;

    @Autowired
    RedisUtils redisUtils;
    @Test
    public void testService() {
        User.UserBuilder user1 = User.builder().id(1).name("user1").age(18);
        List<User> userList=new LinkedList<>();
        for(int i=0;i<3;i++){
            userList.add(User.builder().id(i).name("user"+i).age(18+i).build());
        }
        redisUtils.setCacheObject("listInObject",userList);
        redisUtils.setCacheList("listInList",userList);
        redisUtils.setCacheObject("user1",user1);
        redisUtils.setCacheObject("data",123);
//        redisUtils.keys("*").stream().forEach(t->log.info(t));
        List<User> listInObject = (List<User>)redisUtils.getCacheObject("listInObject");
        List<Object> listInObject1 = redisUtils.getCacheList("listInList");
        listInObject.stream().forEach(t->log.info(t.toString()));
        listInObject1.stream().forEach(t->log.info(t.toString()));
//        redisUtils.clearDatabase();
    }
}