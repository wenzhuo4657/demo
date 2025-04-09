package org.example.runner;



import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ViewCountRunner implements CommandLineRunner {




    @Override
    public void run(String... args) throws Exception {
        System.out.println("springboot启动完成");

    }
}