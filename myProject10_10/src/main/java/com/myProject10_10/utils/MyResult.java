package com.myProject10_10.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyResult {
    public Object data;
    public Integer code;
    public String status;

    public static MyResult success(Object data, Integer code, String status){
        MyResult myResult =new MyResult(data,code,status);
        return myResult;
    }
    public static MyResult success(Object data){
        MyResult myResult =new MyResult();
        myResult.setCode(ResultEnum.success.code);
        myResult.setStatus(ResultEnum.success.stauts);
        myResult.setData(data);
        return myResult;
    }
    public static MyResult success(Object data, Integer code){
        MyResult myResult =new MyResult(data,code,"success");
        return myResult;
    }

}
