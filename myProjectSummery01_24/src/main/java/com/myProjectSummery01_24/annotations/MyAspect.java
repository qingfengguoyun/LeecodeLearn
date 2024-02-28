package com.myProjectSummery01_24.annotations;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;

@Aspect
@Slf4j
@Component
public class MyAspect {

    @Pointcut("execution(* com.myProjectSummery01_24.controller.TestController.*(..))")
    public void pointCut(){

    }

    @Pointcut("@annotation(com.myProjectSummery01_24.annotations.MyAnnotation1)")
    public void pointCut2(){

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        log.info("前置切片");
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        log.info("后置切片");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        log.info("环绕切片开始");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("环绕切片结束");
    }

    @Before("pointCut2()")
    public void before2(JoinPoint joinPoint){
        log.info("基于annotation的前置切片");
    }

    @After("pointCut2()")
    public void after2(JoinPoint joinPoint){
        log.info("基于annotation的后置切片");
    }

    @Around("pointCut2()")
    public void around2(ProceedingJoinPoint proceedingJoinPoint){
        log.info("基于annotation的环绕切片开始");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("基于annotation的环绕切片结束");
    }
}
