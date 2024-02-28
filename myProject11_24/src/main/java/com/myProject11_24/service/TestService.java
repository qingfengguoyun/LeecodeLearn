package com.myProject11_24.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String test(){
        throw new RuntimeException("手动创建的exception");
    }
}
