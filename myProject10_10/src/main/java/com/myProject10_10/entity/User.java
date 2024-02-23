package com.myProject10_10.entity;


import lombok.Data;

import java.lang.reflect.Field;

@Data
public class User {
    String name;
    Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public User(User user){
        Field[] fields=user.getClass().getDeclaredFields();
        try {
            for(Field thisField:fields){
                thisField.setAccessible(true);
                thisField.set(this,thisField.get(user));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
