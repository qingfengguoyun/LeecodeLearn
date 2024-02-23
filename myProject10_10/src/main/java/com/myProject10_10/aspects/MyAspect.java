package com.myProject10_10.aspects;

import com.myProject10_10.utils.MyResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MyAspect {

//    @Pointcut("execution(public * com.myProject10_10.controller.*.*(..))")
//    public void pointCut(){};

    @Pointcut("execution(public * com.myProject10_10.controller.TestController.test(..))")
    public void pointCut(){};

    @Before("pointCut()")
    public void BeforeMethod1(JoinPoint joinPoint){
        System.out.println("原生切片-前置方法");
    }
    @After("pointCut()")
    public void AfterMethod1(JoinPoint joinPoint){
        System.out.println("原生切片-后置方法");
    }
    @Around("pointCut()")
    public void AroundMethod1(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("原生切片-环绕方法-前置");
        joinPoint.proceed();
        System.out.println("原生切片-环绕方法-后置");
    }

    @Pointcut("execution(public * com.myProject10_10.service.TestService.testFunction(..))")
    public void pointCut2(){};

    @Around("pointCut2()")
    public MyResult aroundMethod2(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        StringBuilder stringBuilder=new StringBuilder();
        for(Object obj:args){
            stringBuilder.append(obj.toString()+"  ");
        }
        log.info("传入参数："+stringBuilder);
        Object result = joinPoint.proceed();
        MyResult myResult=(MyResult)result;
        log.info("返回的参数"+myResult.getData().toString());
        return MyResult.success("aop修改后的返回值");
    }
}
