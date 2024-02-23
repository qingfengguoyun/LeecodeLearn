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
public class MyAspect2 {

    @Pointcut("@annotation(com.myProject10_10.annotations.MyAnnotation)")
    public void pointCut2(){
        System.out.println("pointcut");
    }

    @Pointcut("@annotation(com.myProject10_10.annotations.MyAspectAnnotation1)")
    public void pointCut3(){

    }

//    @Before("pointCut2()")
//    public void BeforeMethod1(JoinPoint joinPoint){
//
//        System.out.println("注解切片-前置方法");
//    }
//    @After("pointCut2()")
//    public void AfterMethod1(JoinPoint joinPoint){
//        System.out.println("注解切片-后置方法");
//    }
//    @Around("pointCut2()")
//    public void AroundMethod1(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("注解切片-环绕方法-前置");
//        joinPoint.proceed();
//        System.out.println("注解切片-环绕方法-后置");
//    }

    @Around("pointCut2()")
    public MyResult aroundMethod2(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        log.info(""+args.length);
        StringBuilder stringBuilder=new StringBuilder();
        if(args.length==0){
            return MyResult.success("拦截的方法没有参数");
        }
        for(Object obj:args){
            stringBuilder.append(obj.toString()+"\t");
        }
        log.info(stringBuilder.toString());
        log.info("注解拦截获取参数");
        log.info("传入参数："+stringBuilder);
        Object result = joinPoint.proceed();
        MyResult myResult=(MyResult)result;
        log.info("返回的参数"+myResult.getData().toString());
        return MyResult.success("aop修改后的返回值");
    }

    @Around("pointCut3()")
    public MyResult aroundMethod3(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        StringBuilder stringBuilder=new StringBuilder();
        for(Object obj:args){
            stringBuilder.append(obj.toString()+"\t");
        }
        System.out.println(stringBuilder);
        log.info("注解拦截获取参数");
        log.info("传入参数："+stringBuilder);
        Object result = joinPoint.proceed();
        MyResult myResult=(MyResult)result;
        log.info("返回的参数"+myResult.getData().toString());
        return MyResult.success("aop修改后的返回值");
    }
}
