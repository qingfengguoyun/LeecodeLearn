package com.myProject11_1.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@TableName("t_user")
public class User {

    private Integer id;

    private String name;

    private Integer age;
}
