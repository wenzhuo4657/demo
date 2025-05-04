package cn.wenzhuo4657.config;

import cn.wenzhuo4657.enity.Mybean;
import cn.wenzhuo4657.enity.Yourbean;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: beanConfig
 * @author: wenzhuo4657
 * @date: 2024/8/29 8:56
 * @Version: 1.0
 * @description:
 */
@Configuration(proxyBeanMethods = false)
public class beanConfig  {




    @Bean
    public DruidDataSource druidDataSource(){
        System.out.println("=============================================================");
        System.out.println("druidDataSource1初始化成功！！");
        System.out.println("=============================================");
        return  new DruidDataSource();
    }

//===========================================================
    @Bean
    public Mybean myBean(){
        return new Mybean();
    }

    @Bean
    public Yourbean yourBean(){
        return new Yourbean(myBean());
    }


}