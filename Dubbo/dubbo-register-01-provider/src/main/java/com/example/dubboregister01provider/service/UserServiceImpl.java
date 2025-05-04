package com.example.dubboregister01provider.service;

import cn.wenzhuo4657.dubbo.study.first.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @className: UserServiceImpl
 * @author: wenzhuo4657
 * @date: 2024/6/23 15:43
 * @Version: 1.0
 * @description:
 */
@DubboService
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String name, String password) {
        System.out.println("这是zk："+name+":"+password);
        return false;
    }
}