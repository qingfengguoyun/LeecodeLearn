package com.myProject11_24.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import utils.MyResult;

@RestControllerAdvice
@Configuration
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public MyResult handleRunTimeException(RuntimeException ex){
        return MyResult.success(ex.getMessage());
    }
}
