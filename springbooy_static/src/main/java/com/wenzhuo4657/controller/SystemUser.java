package com.wenzhuo4657.controller;


import com.wenzhuo4657.Reslover.CurrentUserId;
import com.wenzhuo4657.domain.ResponseResult;
import com.wenzhuo4657.domain.User;
import com.wenzhuo4657.domain.userlogin;
import com.wenzhuo4657.mapper.userMapper;
import com.wenzhuo4657.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class SystemUser {
    @Autowired
    userMapper userMapper;

    @RequestMapping(value = "/login")
    public ResponseResult login(@RequestBody userlogin user, HttpSession session){
//1,校验
        userlogin user1=userMapper.login(user);
        Map<String ,Object> map=new HashMap<>();

//        返回
        if (user1!=null){
            String token= JwtUtil.createJWT(UUID.randomUUID().toString(),String.valueOf(user1.getId()),null);
            map.put("token",token);
        }else {
            return  new ResponseResult<>(300,"校验失败，登录异常");
        }
        System.out.println(map.get("token"));
        session.setAttribute("token",map.get("token"));
        return new ResponseResult<>(200,"登录成功");
    }

    @RequestMapping(value = "/loginverify")
    public  ResponseResult loginverify(@CurrentUserId String userId){
        System.out.println("userid:  "+userId+" （ 注解使用");
        return  new ResponseResult<>(200,"正常运行");
    }



}
