package org.wenzhuo4657.test.gateway.controller;

public class TestEnv {
    public static void main(String[] args) {
        String password = System.getenv("MY_PASSWORD");
        System.out.println("MY_PASSWORD=" + password);
    }
}