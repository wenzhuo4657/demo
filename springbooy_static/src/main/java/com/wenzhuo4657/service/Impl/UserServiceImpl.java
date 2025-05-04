package com.wenzhuo4657.service.Impl;

import com.wenzhuo4657.domain.User;
import com.wenzhuo4657.domain.userlogin;
import com.wenzhuo4657.service.UserService;
import  com.wenzhuo4657.mapper.userMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private  userMapper userMapper;

    @Override
    public userlogin login(userlogin user) {
        userlogin login=userMapper.login(user);
        return login;

    }
}
