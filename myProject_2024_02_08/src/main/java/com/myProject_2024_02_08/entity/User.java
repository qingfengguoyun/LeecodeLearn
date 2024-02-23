package com.myProject_2024_02_08.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    Integer id;
    String userName;

    public static class Builder{
        Integer id;
        String userName;

//        public Builder(){
//
//        }
        public Builder id(Integer id){
            this.id=id;
            return this;
        }
        public Builder userName(String userName){
            this.userName=userName;
            return this;
        }
        public User build(){
            User user =new User();
            user.id=this.id;
            user.userName=this.userName;
            return user;
        }
    }

    public static Builder builder(){
        return new Builder();
    }
}
