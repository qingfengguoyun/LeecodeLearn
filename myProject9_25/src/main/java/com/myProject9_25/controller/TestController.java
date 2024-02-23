package com.myProject9_25.controller;

import com.myProject9_25.myAnnotation.MyAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @MyAnnotation
    @GetMapping("/annotationAop")
    public String annotationAopTest() throws NoSuchMethodException {
        Method method=TestController.class.getMethod("annotationAopTest");
        MyAnnotation myAnnotation=method.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.resource());
        System.out.println(myAnnotation.value());
        return "test";
    }

    @GetMapping("/interceptorTest")
    public String interceptorTest(){
        return "test";
    }

    @GetMapping("/exceptionTest")
    public String exceptionTest(){
        throw new RuntimeException("手动抛出");
//        return "test";
    }
}
