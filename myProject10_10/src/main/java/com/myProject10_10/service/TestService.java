package com.myProject10_10.service;

import com.myProject10_10.annotations.MyAnnotation;
import com.myProject10_10.utils.MyResult;
import com.myProject10_10.utils.ResultUtils;
import org.springframework.stereotype.Service;

@Service
public class TestService {


    public MyResult testFunction(String param){
        return MyResult.success(param);
    }


    @MyAnnotation
    public MyResult testFunction2(String param){
        return MyResult.success(param);
    }

    @MyAnnotation
    public MyResult testFunction2(String param1,String param2,String param3){
        return MyResult.success(param1+param2+param3);
    }
}
