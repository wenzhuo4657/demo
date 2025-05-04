package org.wenzhuo4657.oatuh;

import cn.dev33.satoken.sso.SaSsoManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SSO模式一，Client端 Demo
 */
@SpringBootApplication
public class SaSso1ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SaSso1ClientApplication.class, args);
        System.out.println();
        System.out.println("---------------------- Sa-Token SSO 模式一 Client 端启动成功 ----------------------");
        System.out.println("配置信息：" + SaSsoManager.getClientConfig());
        System.out.println("测试访问应用端一: http://location:9000");
        System.out.println();
    }
}
