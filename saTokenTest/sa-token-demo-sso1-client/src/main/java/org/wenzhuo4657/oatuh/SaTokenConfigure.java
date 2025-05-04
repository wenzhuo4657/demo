package org.wenzhuo4657.oatuh;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.spring.SpringMVCUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaFoxUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Sa-Token 配置类 
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    /** 注册 [Sa-Token全局过滤器] */
    @Bean
    public SaServletFilter getSaServletFilter() {
        return new SaServletFilter()
                .addInclude("/**")
                .addExclude("/sso/*", "/favicon.ico")
                .setAuth(obj -> {
                    if(StpUtil.isLogin() == false) {//未登录时的资源拦截
//                        拦截资源，返还给前端401代码，由前端决定，
                        SaRouter.back(SaResult.ok().setCode(401));
//
                    }
                })
                ;
    }
}
