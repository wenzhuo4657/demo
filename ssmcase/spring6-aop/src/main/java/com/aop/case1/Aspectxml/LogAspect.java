package com.aop.case1.Aspectxml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
public class LogAspect {


        public void beforeMethod(JoinPoint joinPoint){
            //获取连接点的签名信息
            String methodName = joinPoint.getSignature().getName();
            //获取目标方法到的实参信息
            String args = Arrays.toString(joinPoint.getArgs());
            System.out.println("Logger-->前置通知，方法名："+methodName+"，参数："+args);
        }

}
