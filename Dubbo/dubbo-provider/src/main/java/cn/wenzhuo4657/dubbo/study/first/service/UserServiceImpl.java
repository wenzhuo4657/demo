package cn.wenzhuo4657.dubbo.study.first.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @className: UserServiceImpl
 * @author: wenzhuo4657
 * @date: 2024/6/20 18:47
 * @Version: 1.0
 * @description:
 */
@Slf4j
@DubboService
public class UserServiceImpl implements  UserService{
    @Override
    public boolean login(String name, String password) {
        log.info("账号：{}，密码：{}",name,password);
        return false;
    }
}