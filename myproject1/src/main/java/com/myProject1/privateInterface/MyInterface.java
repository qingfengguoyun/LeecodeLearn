package com.myProject1.privateInterface;

public class MyInterface {
    public @interface MyAnnotation {
        String value() default "";
        int count() default 0;
    }
}
