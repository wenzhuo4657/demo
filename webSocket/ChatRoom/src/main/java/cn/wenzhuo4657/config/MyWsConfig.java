package cn.wenzhuo4657.config;

import cn.wenzhuo4657.Interceptor.rsInterceptor;
import cn.wenzhuo4657.handler.rsHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import javax.annotation.Resource;

@Configuration
@EnableWebSocket
public class MyWsConfig implements WebSocketConfigurer {
    @Resource
    rsHandler myWsHandler;
    @Resource
    rsInterceptor myWsInterceptor;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myWsHandler,"/myWs1").addInterceptors(myWsInterceptor).setAllowedOrigins("*");
    }
}
