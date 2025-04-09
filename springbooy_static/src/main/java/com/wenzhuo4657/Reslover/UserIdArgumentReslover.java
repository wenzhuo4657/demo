package com.wenzhuo4657.Reslover;

import com.wenzhuo4657.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.StringJoiner;

@Component
public class UserIdArgumentReslover implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUserId.class);
//        注解判断，容器在使用时，如果遇见了未知注解会通过该方法进行判断是否是对应的自定义参数解析器
//        如果该参数使用了CurrentUserId注解，则调用由程序员自定义的重写方法resolveArgument（）
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String token=(String)webRequest.getHeader("token");
        if (StringUtils.hasText(token)){
            Claims claims= JwtUtil.parseJWT(token);
            String userId=claims.getSubject();
            System.out.println("userId: "+userId);
            return userId;
        }

        return null;//此处表明没有传入token，




    }
}
