package com.myProject9_25.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestControllerAdvice
@Configuration
public class GlobalExceptionConfig {


    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException ex){
        return "拦截的运行时错误信息："+ex.getMessage();
    }
}
