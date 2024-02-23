package com.myProject9_25.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @Pointcut("execution(public * com.myProject9_25.controller.TestController.test(..))")
    public void pointCut(){

    }

    @Pointcut("@annotation(com.myProject9_25.myAnnotation.MyAnnotation)")
    public void pointCut2(){

    }

    @Before("pointCut2()")
    public void Before2(JoinPoint joinPoint){
        System.out.println("annotation+aop前置方法");
    }

    @After("pointCut2()")
    public void after2(JoinPoint joinPoint){
        System.out.println("annotation+aop后置方法");
    }

    @Around("pointCut2()")
    public void around2(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("annotation+aopAround前置");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("annotation+aopAround后置");

    }

    @Before("pointCut()")
    public void Before(JoinPoint joinPoint){
        System.out.println("aop前置方法");
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("aop后置方法");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("aopAround前置");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("aopAround后置");

    }
}
