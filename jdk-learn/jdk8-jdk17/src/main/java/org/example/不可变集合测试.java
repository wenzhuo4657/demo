package org.example;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class 不可变集合测试 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list= List.of("Java", "C++");
        Set<String> set = Set.of("Java", "C++");
        Map<String, Integer> map = Map.of("Java", 1, "C++", 2);


        CompletableFuture.runAsync(
                () -> {
                    try {
                        list.add("Python");
                    }catch (Exception e){
                        System.out.println("list集合不可变");
                    }

                });
        CompletableFuture.runAsync(
                () -> {
                    try {
                        set.add("Python");
                    }catch (Exception e){
                        System.out.println("set集合不可变");
                    }
                });
        CompletableFuture.runAsync(
                () -> {
                    try {
                        map.put("Python", 3);
                    }catch (Exception e){
                        System.out.println("map集合不可变");
                    }
                }
        );

        new CountDownLatch(1).await();
    }
}
