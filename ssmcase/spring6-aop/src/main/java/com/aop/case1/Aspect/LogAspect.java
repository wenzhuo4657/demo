package com.aop.case1.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect//标注其为一个切面类
@Component//将这个bean放置进ioc容器中
@EnableAspectJAutoProxy
public class LogAspect {

    @Before("execution(public int com.aop.case1.Calculatorimpl.add( int,int) )")
    public void beforeMethod(){
        System.out.println("Logger-->前置通知");
    }
}


