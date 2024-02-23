package com.myProject9_25.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myProject9_25.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("Select * from user where user_name like concat('%',#{reg},'%')")
    List<User> queryUsersLikeName(String reg);

}
