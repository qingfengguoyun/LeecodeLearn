package com.myProject11_1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myProject11_1.entity.User;
import com.myProject11_1.models.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    public List<User> selectAllUsers();

    @Select("select * from user u where u.name=#{name}")
    public User selectUserByName(String name);

    public List<UserDto> selectAllUserDtos();

    public Integer insertUserInBatch(List<User> users);
}
