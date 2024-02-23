package com.myProjectSummery01_24.service;

import com.myProjectSummery01_24.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedisCacheService {

    @Autowired
    RedisUtils redisUtils;

    @Cacheable(value="redisCacheTest",key="#id")
    public String redisCacheTest(Integer id){
      log.info("首次执行，id="+id);
//        Object redisCacheTest = redisUtils.getCacheObject("redisCacheTest");
//        log.info("redisCacheObject:"+redisCacheTest.toString());
        return id.toString();
    }
}
