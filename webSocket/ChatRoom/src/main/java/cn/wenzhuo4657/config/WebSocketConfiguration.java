package cn.wenzhuo4657.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


@Configuration
public class WebSocketConfiguration {
    @Bean
    public  ServerEndpointExporter serverEndpointExporter(){
        return  new ServerEndpointExporter();//该对象的注入会使spring容器开启对服务端实例的扫描，
    }

}