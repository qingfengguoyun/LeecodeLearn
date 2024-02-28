package com.myProject9_25.entity;

import com.myProject9_25.utils.MyBeanUtils;
import lombok.Data;

@Data
public class MyDataDto {
    private Integer id;
    private String value;
    private String value2;

    public static void main(String[] args) {
        MyData md=new MyData();
        MyDataDto mdd=new MyDataDto();
        md.setId(1);
        md.setValue("123");

        try {
            MyBeanUtils.copyBean(md,mdd);
            System.out.println(md);
            System.out.println(mdd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
