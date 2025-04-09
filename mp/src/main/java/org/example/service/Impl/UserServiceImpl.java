package org.example.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.domian.User;
import org.example.mapper.UserMapper;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
