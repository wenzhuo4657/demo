package org.example.config;


import org.example.filter.WebSocketHandleInterceptor;
import org.example.handler.WebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

///**
// *
// * Websocket配置类
// *
// * @author lucky_fd
// * @since 2024-01-17
// */
//@Configuration
//@EnableWebSocket
//public class WebSocketConfig implements WebSocketConfigurer {
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        // 注册websocket处理器和拦截器
//        registry.addHandler(webSocketHandler(), "/websocket/server")
//                .addInterceptors(webSocketHandleInterceptor()).setAllowedOrigins("*");
//        registry.addHandler(webSocketHandler(), "/sockjs/server").setAllowedOrigins("*")
//                .addInterceptors(webSocketHandleInterceptor()).withSockJS();
//    }
//
//    @Bean
//    public WebSocketHandler webSocketHandler() {
//        return new WebSocketHandler();
//    }
//
//    @Bean
//    public WebSocketHandleInterceptor webSocketHandleInterceptor() {
//        return new WebSocketHandleInterceptor();
//    }
//}