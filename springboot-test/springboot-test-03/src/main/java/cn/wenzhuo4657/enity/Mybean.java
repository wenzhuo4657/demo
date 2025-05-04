package cn.wenzhuo4657.enity;

import javax.annotation.PostConstruct;

/**
 * @className: Mybean
 * @author: wenzhuo4657
 * @date: 2024/8/29 9:18
 * @Version: 1.0
 * @description:
 */
public class Mybean {
//    该注解为spring内部的注解，则如果该未生效，则表明spring的代理、生命周期未在这个bean中生效
    @PostConstruct
    public void init(){
        System.out.println("MyBean初始化了");
    }
    public void hello(){
        System.out.println("Mybean  hello");
    }
}