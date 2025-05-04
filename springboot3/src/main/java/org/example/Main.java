package org.example;


import org.example.config.po;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.boot.availability.LivenessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Main implements ApplicationRunner {


    @Autowired
    private ApplicationAvailability availability;


    @Autowired
    private  ApplicationEventPublisher eventPublisher;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LivenessState livenessState = availability.getLivenessState();
        System.out.println(livenessState);
        eventPublisher.publishEvent(po.build(livenessState));


    }


    public static void main(String[] args) {
//        SpringApplication application = new SpringApplication(Main.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.setWebApplicationType(WebApplicationType.SERVLET);
//        BufferingApplicationStartup bufferingApplicationStartup = new BufferingApplicationStartup(2048);
//        application.setApplicationStartup(bufferingApplicationStartup);
//        ConfigurableApplicationContext run = application.run(args);


//      1,启动配置
        SpringApplication springApplication = new SpringApplication(Main.class);

        Map<String, Object> defaultProperties = new HashMap<>();
        defaultProperties.put("server", 8084);
        springApplication.setDefaultProperties(defaultProperties);

//        2，启动
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        String property = context.getEnvironment().getProperty("server");

//        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
//        builder.bannerMode(Banner.Mode.OFF);
//        builder.run(args);
    }

//    @GetMapping("/testCallAble")
//    public Callable<String> test(HttpServletResponse response){
//        return new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Thread.sleep(5000);
//
//                return "helloworld";
//            }
//        };
//    }







}