package com.myProject10_10.controller;

import com.myProject10_10.annotations.MyAnnotation;
import com.myProject10_10.service.MyService;
import com.myProject10_10.service.TestService;
import com.myProject10_10.utils.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    TestService testService;

    @Autowired
    MyService myService;

    @GetMapping("/test")
    @MyAnnotation
    public void test(){
        System.out.println("test");
        try {
            Class controllerClass=Class.forName("com.myProject10_10.controller.TestController");
            Method method=controllerClass.getMethod("test");
            MyAnnotation annotation=method.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.name());
            System.out.println(annotation.value());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/test2")
    public MyResult test2(){
        return MyResult.success(testService.testFunction("123"));
    }

    @GetMapping("/test22")
    public MyResult test22(@RequestParam(required = false) String arg,
                           @RequestParam(required = false) String arg2,
                           @RequestParam(required = false) String arg3){
        return MyResult.success(testService.testFunction2(arg,arg2,arg3));
    }

    @GetMapping("/test3")
    public MyResult test3(){

        System.out.println("qwe");
        myService.methodA();
        return MyResult.success("");
    }


}
