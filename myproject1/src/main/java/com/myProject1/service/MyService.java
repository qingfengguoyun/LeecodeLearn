package com.myProject1.service;

import com.myProject1.myInterfaces.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyService {

    @LogExecutionTime()
    public void test(){

        log.info("test is down");
    }

}
