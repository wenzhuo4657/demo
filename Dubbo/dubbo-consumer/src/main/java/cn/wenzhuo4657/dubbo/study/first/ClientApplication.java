package cn.wenzhuo4657.dubbo.study.first;

import cn.wenzhuo4657.dubbo.study.first.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @className: main
 * @author: wenzhuo4657
 * @date: 2024/6/20 18:33
 * @Version: 1.0
 * @description:
 */
public class ClientApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext-provider.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        boolean ret = userService.login("小名", "1234565");
        System.out.println(ret);
        new CountDownLatch(1).await();
    }
}