package com.myProjectViewTest.controller;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TestAspect {

    @Before("execution(* com.myProjectViewTest.controller.TestController.test(..))&& args(s)")
    public void boforeTest(JoinPoint joinPoint,String s){
        log.info("arg:"+s);
        log.info("前置切片");
    }
}
