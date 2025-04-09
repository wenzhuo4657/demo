package cn.wenzhuo4657.config;


import cn.wenzhuo4657.enity.Mybean;
import cn.wenzhuo4657.enity.Yourbean;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: bean2Config
 * @author: wenzhuo4657
 * @date: 2024/8/29 8:58
 * @Version: 1.0
 * @description:
 */
@Configuration(proxyBeanMethods = true)
public class bean2Config {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        System.out.println("=============================================================");
        System.out.println("MybatisPlusInterceptor初始化成功！！");
        System.out.println("=============================================");
        return  new MybatisPlusInterceptor();
    }



//    ==================================================================



}