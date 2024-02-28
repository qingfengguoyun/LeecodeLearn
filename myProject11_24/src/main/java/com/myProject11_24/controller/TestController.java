package com.myProject11_24.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.MyResult;

import java.util.regex.Pattern;



@RestController
@RequestMapping("/api")
@Slf4j
public class TestController {



    @GetMapping("/test")
    public void test(){
        boolean matches = Pattern.matches(".*message.*", "developmentmessage");
        System.out.println(matches);
        log.info("test");
    }

    @GetMapping("/test2")
    public MyResult test2(){
        RuntimeException ex = new RuntimeException("手动创建的运行时错误");
        throw ex;
//        return MyResult.success("success");
    }




    @GetMapping("/test3")
    public MyResult test3(){
        return null;
    }
}
