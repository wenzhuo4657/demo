package cn.wenzhuo4657.dubbo.study.first;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @className: main
 * @author: wenzhuo4657
 * @date: 2024/6/20 18:33
 * @Version: 1.0
 * @description:
 */
public class main {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext-provider.xml");
        applicationContext.start();
        new CountDownLatch(1).await();
    }
}