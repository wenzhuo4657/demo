package cn.wenzhuo4657.test01.config;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @className: cn.wenzhuo4657.test01.config.serverConfig
 * @author: wenzhuo4657
 * @date: 2024/8/27 19:38
 * @Version: 1.0
 * @description:
 */

@Configuration
public class serverConfig {

    @Bean
    public  String xxMsg(){
        return  "这是一个第三方、简单的bean。";
    }


}