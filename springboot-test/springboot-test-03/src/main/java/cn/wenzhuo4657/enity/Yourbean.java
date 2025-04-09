package cn.wenzhuo4657.enity;

import javax.annotation.PostConstruct;

/**
 * @className: Yourbean
 * @author: wenzhuo4657
 * @date: 2024/8/29 9:18
 * @Version: 1.0
 * @description:
 */
public class Yourbean {
    public Mybean myBean;

    public Yourbean(Mybean myBean){
        this.myBean=myBean;
    }

    @PostConstruct
    public void init(){
        System.out.println("YourBean 初始化了");
    }

    public void hello(){
        System.out.println("YourBean hello");
    }
}