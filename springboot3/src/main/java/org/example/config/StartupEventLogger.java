package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.core.metrics.StartupStep;
import org.springframework.stereotype.Component;

//@Component
//public class StartupEventLogger {
//
//    private final BufferingApplicationStartup bufferingApplicationStartup;
//
//    @Autowired
//    public StartupEventLogger(BufferingApplicationStartup bufferingApplicationStartup) {
//        this.bufferingApplicationStartup = bufferingApplicationStartup;
//    }
//
//    public void logStartupEvents() {
//        // 获取所有启动步骤
//        bufferingApplicationStartup.getBufferedTimeline().getEvents().forEach(step -> {
//            StartupStep startupStep = step.getStartupStep();
//            System.out.println("Step Name: " + startupStep.getName());
//            System.out.println("Tags: " + startupStep.getTags());
//            System.out.println("Duration: " + step.getDuration() + " ms");
//        });
//    }
//}