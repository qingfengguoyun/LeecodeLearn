package com.myProject9_25.service;

import com.myProject9_25.dao.UserMapper;
import com.myProject9_25.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Integer insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer UpdateUser(User user) {
        return userMapper.updateById(user);

    }

    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> queryUserLikeName(String name) {
        return userMapper.queryUsersLikeName(name);
    }
}
