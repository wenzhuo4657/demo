package com.wenzhuo4657.interceptor;

import com.wenzhuo4657.config.MyControllerAdvice;
import com.wenzhuo4657.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class loginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1,获取token
        String  token=(String) request.getSession().getAttribute("token");

//        2,判断token是否有效
        if (!StringUtils.hasText(token)){
            throw new RuntimeException("未登录");
        }

        try{
            Claims claims= JwtUtil.parseJWT(token);
            String sub=claims.getSubject();
            System.out.println("sub: "+sub);
        }catch (Exception e){
            throw new RuntimeException("解析token失败");
        }
        return true;//放行
    }


}
