package com.myProject2024_1_10.service;

import com.myProject2024_1_10.entity.User;
import com.myProject2024_1_10.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

@Service
public class RedisTestService {

    @Autowired
    RedisCache redisCache;

    public void test(){
        String str="redis存储字符串";
        redisCache.setCacheObject("String",str);
        Object strFromRedis = redisCache.getCacheObject("String");
        System.out.println(strFromRedis);

        Map<String, User> map=new HashMap<>();
        for(Integer i: IntStream.rangeClosed(1,10).toArray()){
            map.put(i.toString(),User.builder().id(i).name("用户"+i).build());
        }
        redisCache.setCacheMap("Map",map);
        Map<String, Object> mapFromRedis = redisCache.getCacheMap("Map");
        mapFromRedis.entrySet().stream().forEach(t->{
            System.out.println(t.getValue());
        });

    }
}
