package com.myProject1.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String testService1() {
        return "ok";
    }
}
