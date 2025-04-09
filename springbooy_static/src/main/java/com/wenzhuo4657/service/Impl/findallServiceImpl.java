package com.wenzhuo4657.service.Impl;

import com.wenzhuo4657.domain.User;
import com.wenzhuo4657.service.findallService;
import com.wenzhuo4657.mapper.userMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class findallServiceImpl implements findallService {
    @Autowired
    private  userMapper userMapper;
    @Override
    public List<User> findall() {
        return userMapper.finadll();
    }

}
