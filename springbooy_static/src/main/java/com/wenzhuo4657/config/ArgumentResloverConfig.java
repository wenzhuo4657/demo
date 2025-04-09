package com.wenzhuo4657.config;

import com.wenzhuo4657.Reslover.UserIdArgumentReslover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class ArgumentResloverConfig implements WebMvcConfigurer {

    @Autowired
    public UserIdArgumentReslover userIdArgumentReslover;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userIdArgumentReslover);
    }
}
