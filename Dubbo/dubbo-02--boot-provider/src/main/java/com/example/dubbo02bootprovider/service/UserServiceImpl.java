package com.example.dubbo02bootprovider.service;

import cn.wenzhuo4657.dubbo.study.first.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @className: UserServiceImpl
 * @author: wenzhuo4657
 * @date: 2024/6/21 14:33
 * @Version: 1.0
 * @description:
 */
@DubboService
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String name, String password) {
        System.out.println("姓名是"+name+"的人的密码是"+password);
        return false;
    }
}