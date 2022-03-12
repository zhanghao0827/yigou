package com.yigou.user.service.impl;

import com.yigou.common.entity.User;
import com.yigou.user.mapper.UserMapper;
import com.yigou.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
