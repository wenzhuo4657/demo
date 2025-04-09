package com.wenzhuo4657.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wenzhuo4657.domain.LoginUser;
import com.wenzhuo4657.domain.User;
import com.wenzhuo4657.mapper.Usermapper;
import com.wenzhuo4657.mapper.menumapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

    @Autowired
    private Usermapper usermapper;

    @Autowired
    private menumapper menumapper;

//    取消默认的用户名密码，从数据库中获取完整的用户信息传入Securiy中进行验证
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        User user=usermapper.selectOne(queryWrapper);

        if (Objects.isNull(user)){
            throw new RuntimeException("未知用户");
        }

//      权限信息，
        List<String> list = menumapper.Permissions(user.getId());

        return new LoginUser(user,list);
    }
}
