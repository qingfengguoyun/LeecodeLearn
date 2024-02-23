package com.myProject10_10.entity;

public class Test {
    public static void main(String[] args) {
        User user1=new User();
        user1.setName("qwe");
        user1.setAge(11);
        User user2=new User(user1);
        System.out.println(user2);
        ExtendUser exUser=new ExtendUser(user1);
        System.out.println(exUser);
        System.out.println(exUser.getName());
    }
}
