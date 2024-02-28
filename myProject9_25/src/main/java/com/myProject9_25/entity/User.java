package com.myProject9_25.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name= "password")
    private String password;

    public User(Builder builder){
        this.userName=builder.userName;
        this.password=builder.password;
    }

    public static class Builder{
        String userName;
        String password;
        public Builder userName(String userName){
            this.userName=userName;
            return this;
        }
        public Builder password(String password){
            this.password=password;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }


}
