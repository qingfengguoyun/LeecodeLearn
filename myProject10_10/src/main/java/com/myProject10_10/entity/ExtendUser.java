package com.myProject10_10.entity;

import lombok.Data;

import java.lang.reflect.Field;

@Data
public class ExtendUser extends User {
    String gender;


    public ExtendUser(User user) {
        Field[] fileds=user.getClass().getDeclaredFields();
        try {
            for(Field field:fileds){
                field.set(this,field.get(user));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
