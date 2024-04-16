package cn.wenzhuo4657.config;

import cn.wenzhuo4657.Interceptor.rsInterceptor;
import cn.wenzhuo4657.handler.rsHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.annotation.Resource;


@Configuration
public class WebSocketConfiguration {
    @Bean
    public  ServerEndpointExporter serverEndpointExporter(){
        return  new ServerEndpointExporter();//该对象的注入会使spring容器开启对服务端实例的扫描，
    }

}