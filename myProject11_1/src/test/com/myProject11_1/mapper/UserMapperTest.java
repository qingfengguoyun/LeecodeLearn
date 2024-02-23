package com.myProject11_1.mapper;

import com.myProject11_1.entity.User;
import com.myProject11_1.models.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void selectAllUsers() {
        List<User> users = userMapper.selectAllUsers();
        users.stream().forEach(t-> System.out.println(t));
    }

    @Test
    public void selectUserByName() {
        User qwe2 = userMapper.selectUserByName("qwe2");
        System.out.println(qwe2);
    }

    @Test
    public void selectAllUserDtos() {
        List<UserDto> userDtos = userMapper.selectAllUserDtos();
        userDtos.stream().forEach(t-> System.out.println(t));
    }

    @Test
    public void insertUserInBatch() {
        List<User> users=new LinkedList<User>(){{
            add(User.builder().name("asd").age(5).build());
            add(User.builder().name("asd2").age(5).build());

        }};
        Integer rows = userMapper.insertUserInBatch(users);
        System.out.println(rows);
        users.stream().forEach(t-> System.out.println(t));
    }
}