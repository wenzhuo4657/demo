package com.wenzhuo4657.filter;

import com.wenzhuo4657.domain.LoginUser;
import com.wenzhuo4657.utils.JwtUtil;
import com.wenzhuo4657.utils.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class tokenFilter extends OncePerRequestFilter {
    @Autowired
    private RedisCache redisCache;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        1,获取token，
        String token=request.getHeader("token");
        if (!StringUtils.hasText(token)){
            filterChain.doFilter(request,response);
            return;
//            如果没有token，则结束方法，继续执行下一过滤器
        }

//        2，解析token
        String userid;
        try{
            Claims claims= JwtUtil.parseJWT(token);
            userid=claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();//打印错误信息
            throw new RuntimeException(e);
        }
//     3。从redis获取完整的用户信息
        String key="login:"+userid;
        LoginUser loginUser= redisCache.getCacheObject(key);
        if (Objects.isNull(loginUser)){
            throw  new RuntimeException("token异常：可以正确解析，但redis中不存在对应信息");
        }



//     4.存入authentication中
        UsernamePasswordAuthenticationToken Token=
                new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(Token);


//        5，调用下一过滤器
        filterChain.doFilter(request,response);



    }
}
