package org.example.domain.enity;


import org.springframework.stereotype.Component;

@Component
public class hello1 {
    public hello1() {
        System.out.println("这是hello");
    }

    public void hello() {
        System.out.println("服务1");
    }
}
