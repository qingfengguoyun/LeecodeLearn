package com.myProject9_25.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyBeanUtils {

//    private class TypeAndName{
//        String Type
//    }

    public static void copyBean(Object o1,Object o2) throws Exception{
        Class<?> o1Class=o1.getClass();
        Field[] o1Fields=o1Class.getDeclaredFields();
        Map<String,Field> map1=Arrays.asList(o1Fields).stream().collect(Collectors.toMap(Field::getName,field -> field));
//        Map<String,>
        Class<?> o2Class=o2.getClass();
        Field[] o2Fields=o2Class.getDeclaredFields();

        for(Field f:o2Fields){
            //如果有同名变量
            if(map1.containsKey(f.getName())){
                Field f2=map1.get(f.getName());
                //如果类型也相同则将o1的成员变量值赋予o2对应的成员变量
                if(f2.getType().equals(f.getType())){
                    f.setAccessible(true);
                    f2.setAccessible(true);
                    f.set(o2,f2.get(o1));
                }
            }
        }
    }
}
