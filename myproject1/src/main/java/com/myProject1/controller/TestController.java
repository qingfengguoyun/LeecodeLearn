package com.myProject1.controller;

import com.myProject1.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private MyService myService;
    @GetMapping("/test")
    public String test(){
        myService.test();
        return "test";
    }


    public static void main(String[] args) {
        ClassB b=new ClassB();
        b.setFileName("qwe");
        b.setPropertyA("pa");
        //当父类的引用指向一个子类的对象时，通过该引用调用的方法将执行子类中的实现
        //此处即是父类A的引用指向其子类B的实例，调用的getFileName实际是B中的getfileName方法
        ClassA a=b;
        System.out.println(a.getFileName());
        System.out.println(a.getPropertyA());
        log.info("slf4j");
    }
}
