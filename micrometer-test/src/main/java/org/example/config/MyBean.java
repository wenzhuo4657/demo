package org.example.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class MyBean {
    public MyBean(MeterRegistry registry) {
//        计时器
        registry.counter("mycounter", "mytag", "1");

//         仪表盘
        registry.gauge("mygauge", 1);

//        直方图
        Timer.builder("mytimer")
                .publishPercentiles(0.5, 0.95) // median and 95th percentile
                .publishPercentileHistogram()
                .serviceLevelObjectives(Duration.ofMillis(100))
                .minimumExpectedValue(Duration.ofMillis(1))
                .maximumExpectedValue(Duration.ofSeconds(10)).register(registry);
//        摘要

        registry.summary("mysummary", "mytag", "1");


    }


}

