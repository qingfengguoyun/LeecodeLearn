package com.myProject2024_1_10.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    Integer id;
    String name;

    public static class Builder{
        Integer id;
        String name;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public User build(){
            return new User(this.id,this.name);
        }
    }
    public static Builder builder(){
        return new Builder();
    }
}
