package org.example;


import org.example.config.po;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.core.metrics.jfr.FlightRecorderApplicationStartup;

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
        SpringApplication application = new SpringApplication(Main.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.setWebApplicationType(WebApplicationType.SERVLET);
        BufferingApplicationStartup bufferingApplicationStartup = new BufferingApplicationStartup(2048);
        application.setApplicationStartup(bufferingApplicationStartup);
        ConfigurableApplicationContext run = application.run(args);




//        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
//        builder.bannerMode(Banner.Mode.OFF);
//        builder.run(args);



    }
}