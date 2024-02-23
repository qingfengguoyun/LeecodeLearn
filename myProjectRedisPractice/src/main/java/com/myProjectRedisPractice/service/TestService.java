package com.myProjectRedisPractice.service;

import com.myProjectRedisPractice.entity.User;
import com.myProjectRedisPractice.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestService {

    @Autowired
    RedisUtils redisUtils;

    public void testService(){
        User.UserBuilder user1 = User.builder().id(1).name("user1").age(18);
        redisUtils.setCacheObject("user1",user1);
        redisUtils.setCacheObject("data",123);
    }
}
