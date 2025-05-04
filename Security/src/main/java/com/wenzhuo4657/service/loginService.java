package com.wenzhuo4657.service;

import com.wenzhuo4657.domain.ResponseResult;
import com.wenzhuo4657.domain.User;

public interface loginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
