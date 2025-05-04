package org.example.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
@EnableWebMvc//使springboot的默认mvc配置失效
@ComponentScan("org.example.controller")
public class WebMvcConfig  {

    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for(HttpMessageConverter httpMessageConverter:converters){
            if(StringHttpMessageConverter.class.isAssignableFrom(httpMessageConverter.getClass())){
                ((StringHttpMessageConverter)httpMessageConverter).setDefaultCharset(Charset.forName("UTF-8"));
            }
        }
    }
}
