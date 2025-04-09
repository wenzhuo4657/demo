package com.wenzhuo4657.controller;

import com.wenzhuo4657.domain.ResponseResult;
import com.wenzhuo4657.domain.User;
import com.wenzhuo4657.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private loginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){

        return loginService.login(user);

    }

    @RequestMapping("/user/logout")
    public  ResponseResult logput(){
       return loginService.logout();

    }


}
