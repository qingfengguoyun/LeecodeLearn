package com.myProject1.myAspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("@annotation(com.myProject.myInterfaces.LogExecutionTime)")
    public void executionTimePointcut() {}

    @Before("executionTimePointcut()")
    public void logBeforeExecution() {
        System.out.println("Before method execution");
    }

    @AfterReturning("executionTimePointcut()")
    public void logAfterExecution() {
        System.out.println("After method execution");
    }

    @Around("executionTimePointcut()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Method execution time: " + (endTime - startTime) + " milliseconds");
        return result;
    }
}