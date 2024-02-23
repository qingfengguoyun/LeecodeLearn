package com.myProject9_25.service;

import com.myProject9_25.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public Integer insertUser(User user);

    public Integer UpdateUser(User user);

    public User getUserById(Long id);

    public List<User> queryUserLikeName(String name);
}
