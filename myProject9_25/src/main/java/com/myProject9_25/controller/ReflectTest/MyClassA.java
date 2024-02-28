package com.myProject9_25.controller.ReflectTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MyClassA {

    private Integer id;
    private String name;
    private String password;

    public void method1(){
        System.out.println("MyClassA方法");
    }

    public void method2(String str){
        System.out.println("接收参数："+str);
    }


    public static void main(String[] args) {
        try {
            Class<?> aClass=Class.forName("com.myProject9_25.controller.ReflectTest.MyClassA");
            Field[] fields=aClass.getDeclaredFields();
            Map<String,Field> map1= Arrays.asList(fields).stream().collect(Collectors.toMap(Field::getName, field -> field));
            System.out.println(map1);
            Field idField=aClass.getDeclaredField("id");

            idField.setAccessible(true);
            MyClassA a=(MyClassA)aClass.newInstance();
            idField.set(a,123);
            System.out.println(a);

            Method method=aClass.getMethod("method1",null);
            method.invoke(a);

            Method method2=aClass.getMethod("method2", String.class);
            method2.invoke(a,"qwer");

        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MyClassA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
