package com.myProject9_21.entity;

public class MyEntity {

    private String str;
    private Integer number;

    public MyEntity() {
    }

    public MyEntity(String str, Integer number) {
        this.str = str;
        this.number = number;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    //类里添加以Builder对象为参数的构造方法
    public MyEntity(Builder builder){
        this.str=builder.str;
        this.number=builder.number;
    }

    @Override
    public String toString() {
        return "MyEntity{" +
                "str='" + str + '\'' +
                ", number=" + number +
                '}';
    }

    //静态内部类Builder
    public static class Builder{
        String str;
        Integer number;

        //与成员对象同名的构造方法
        public Builder str(String str){
            this.str=str;
            return this;
        }

        public Builder number(Integer number){
            this.number=number;
            return this;
        }

        //调用主类的构造方法返回主类的实例
        public MyEntity build(){
            return new MyEntity(this);
        }
    }
}
