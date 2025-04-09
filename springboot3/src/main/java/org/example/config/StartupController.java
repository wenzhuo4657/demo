package org.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartupController {

    Logger log = LoggerFactory.getLogger(StartupController.class);

    private final StartupEventLogger startupEventLogger;

    public StartupController(StartupEventLogger startupEventLogger) {
        this.startupEventLogger = startupEventLogger;
    }

    @GetMapping("/startup-events")
    public void getStartupEvents() {
        startupEventLogger.logStartupEvents();
        log.info("Check console for startup events!");
    }
}