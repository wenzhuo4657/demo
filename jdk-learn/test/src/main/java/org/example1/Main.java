package org.example1;

import org.example.user;


import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {

        ServiceLoader<user> loader = ServiceLoader.load(user.class);
        loader.iterator().forEachRemaining(user::show);
       }
}