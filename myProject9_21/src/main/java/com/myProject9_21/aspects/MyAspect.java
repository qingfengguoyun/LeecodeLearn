package com.myProject9_21.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class MyAspect {

    @Pointcut("execution(public * com.myProject9_21.controller.*.*(..))")
    public void pointCut(){
    };

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("aop_before");
//        log.info("aop_before");
    }

}
