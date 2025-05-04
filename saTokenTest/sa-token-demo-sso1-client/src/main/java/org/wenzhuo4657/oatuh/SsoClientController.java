package org.wenzhuo4657.oatuh;

import ch.qos.logback.classic.spi.EventArgUtil;
import cn.dev33.satoken.sso.SaSsoManager;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sa-Token-SSO Client端 Controller 
 * @author click33
 */
@RestController
public class SsoClientController {

    // SSO-Client端：首页 
    @RequestMapping("/")
    public String index() {
        String authUrl = SaSsoManager.getClientConfig().splicingAuthUrl();
        String solUrl = SaSsoManager.getClientConfig().splicingSloUrl();
        String str = "<h2>Sa-Token SSO-Client 应用端</h2>" + 
                    "<p>当前会话是否登录：" + StpUtil.isLogin() + "</p>" +
                    "<p><a href=\"javascript:location.href='" + authUrl + "?mode=simple&redirect=' + encodeURIComponent(location.href);\">登录</a> " + 
                    "<a href=\"javascript:location.href='" + solUrl + "?back=' + encodeURIComponent(location.href);\">注销</a> </p>";
        return str;
    }

    @RequestMapping("/login")
    public String login() {
//        1,判断登录状态，如果没有登录将对话重定向到认证中心，
//        对于单点登录来说，除认证中心之外的模块，他们对于权限的管理应当是， 1，有无权限 ，2交给认证中心判断，3，session信息存储在第三方的redis当中
//        但是依旧有问题，
//        1，具体的权限应当定义到数据库当中，前端通过路由控制显示用户可以调用的api
//        2，假设用户在意外情况下调用了没有权限的api，应该如何判断？
//        无论如何对于权限的管理应当深入到url级别，
        String authUrl = SaSsoManager.getClientConfig().splicingAuthUrl();
        String solUrl = SaSsoManager.getClientConfig().splicingSloUrl();
        String str = "<h2>Sa-Token SSO-Client 应用端</h2>" +
                "<p>当前会话是否登录：" + StpUtil.isLogin() + "</p>" +
                "<p><a href=\"javascript:location.href='" + authUrl + "?mode=simple&redirect=' + encodeURIComponent(location.href);\">登录</a> " +
                "<a href=\"javascript:location.href='" + solUrl + "?back=' + encodeURIComponent(location.href);\">注销</a> </p>";
        return str;
    }
    
    // 全局异常拦截 
    @ExceptionHandler
    public SaResult handlerException(Exception e) {
        e.printStackTrace(); 
        return SaResult.error(e.getMessage());
    }
    
}
