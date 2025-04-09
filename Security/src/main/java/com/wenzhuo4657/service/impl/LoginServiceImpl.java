package com.wenzhuo4657.service.impl;

import com.wenzhuo4657.domain.LoginUser;
import com.wenzhuo4657.domain.ResponseResult;
import com.wenzhuo4657.domain.User;
import com.wenzhuo4657.service.loginService;
import com.wenzhuo4657.utils.JwtUtil;
import com.wenzhuo4657.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Service
public class LoginServiceImpl implements loginService {

    @Autowired
    private AuthenticationManager Manager;

    @Autowired
    private RedisCache redisCache;
    @Override
    public ResponseResult login(User user) {

//        1，将用户名、密码交给manager

        UsernamePasswordAuthenticationToken AuthenticationToken=
                new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authentication=Manager.authenticate(AuthenticationToken);

//       2,判null
        if (Objects.isNull(authentication)){
            throw new RuntimeException("登录失败");
        }
//       3，根据用户id生成jwt
        LoginUser LU=(LoginUser) authentication.getPrincipal();
        String userid=LU.getUser().getId().toString();
        String jwt= JwtUtil.createJWT(userid);

//       4,将用户信息存入redis
        redisCache.setCacheObject("login:"+userid,LU);

//        5，返回响应体
        Map<String,String> map =new HashMap<>();
        map.put("token",jwt);
        return new ResponseResult<>(200,"登录成功",map);
    }

//    这里的退出登录仅仅是删除redis中的信息，使再次携带token的请求在执行中，过滤器tokenFilter中抛出错误终止请求
    @Override
    public ResponseResult logout() {
        Authentication authentication=
                SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser=(LoginUser) authentication.getPrincipal();
        Long userid =loginUser.getUser().getId();
        redisCache.deleteObject("login:"+userid);
        return new ResponseResult<>(200,"成功退出");
    }
}
