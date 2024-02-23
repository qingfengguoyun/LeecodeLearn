package com.myProject11_24.aspects;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Aspect
@Component
@Slf4j
public class MyAspect1 {

    @Pointcut("@annotation(com.myProject11_24.annotations.MyAnnotation1)")
    public void pointCut1(){

    }



    @Around("pointCut1()")
    public List<Long> afterTest(ProceedingJoinPoint joinPoint) throws Throwable{
        Object proceed = joinPoint.proceed();
        log.info("后置拦截成功");
        ((LinkedList<Long>) proceed).add(2L);

        return (LinkedList<Long>)proceed;
    }
}
