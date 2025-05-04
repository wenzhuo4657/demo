package cn.wenzhuo4657.test01;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

/**
 * @className: springbootTest02
 * @author: wenzhuo4657
 * @date: 2024/8/27 20:05
 * @Version: 1.0
 * @description: 测试程序中使用第三方bean
 *
 * 之所以说是第三方bean,是因为其使用注解@Configuration，该注解定义的类内部使用@Bean注入第三方，
 * 但是其只会在程序上下文中引用时才进行注入，这种机制也减轻了大量引入外部框架，但实际上只使用一部分bean的浪费情况，
 * 对标到此处的测试类，即导入该配置类，将其强制生效。
 */

@SpringBootTest
@Import(cn.wenzhuo4657.test01.config.serverConfig.class)
public class springbootTest02 {

    @Resource(name = "xxMsg")
    String bean;


    @Test
    public  void test(){
        System.out.println(bean);
    }
}