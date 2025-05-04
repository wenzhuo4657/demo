package cn.wenzhuo4657.jdk;

import cn.wenzhuo4657.jdk.Jdk;
import cn.wenzhuo4657.jdk.stu;
import cn.wenzhuo4657.jdk.stuImpl;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.lang.reflect.Proxy;

/**
 * @className: test
 * @author: wenzhuo4657
 * @date: 2024/6/14 17:16
 * @Version: 1.0
 * @description:
 */
public class test {

    @Test
    public  void testJdk(){
        stuImpl stu=new stuImpl();
        ClassLoader classLoader = stu.getClass().getClassLoader();
        Class<?>[] interfaces = stu.getClass().getInterfaces();
//        封装代理类的执行逻辑处理器
        Jdk jdk = new Jdk(stu);
        stu proxy= (cn.wenzhuo4657.jdk.stu) Proxy.newProxyInstance(classLoader,interfaces,jdk);
        proxy.goSchool();



        String s="";
        s.substring()


    }
}