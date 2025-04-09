package cn.wenzhuo4657.test01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @className: springbootTest
 * @author: wenzhuo4657
 * @date: 2024/8/27 19:49
 * @Version: 1.0
 * @description:  测试程序中读取配置
 *
 * 其中注解springbootTest的属性properties可以覆盖值，也可以添加临时属性
 * 同时还有args属性也可以达到相同效果
 *
 * 此时有三种方式配置，优先级依次为args、properties、直接在配置文件中编写
 * args相当于命令行级别，所以最高
 */
@SpringBootTest(properties = {"sss.aaa=只能坚持下去了","bbb.ddd=12314"},args = {"sss.aaa=我不知道啊"})
public class springbootTest01 {

    @Value("${sss.aaa}")
    private  String str;

    @Value("${bbb.ddd}")
    private  String  rts;

    @Value("${bbb.ddd}")
    private  Integer  ttt;


    @Test
    void xxxtest(){
        System.out.println(str);
        System.out.println(rts);
        System.out.println(ttt);
    }
}