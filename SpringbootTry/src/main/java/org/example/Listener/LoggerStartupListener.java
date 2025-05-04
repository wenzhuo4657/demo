package org.example.Listener;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;

import java.io.File;
import java.util.Arrays;

public class LoggerStartupListener extends ContextAwareBase implements LoggerContextListener, LifeCycle {

    private static final String DEFAULT_LOG_FILE = "MYAPP";

    private boolean started = false;

    @Override
    public void start() {
        if( started )
            return;

        File file=new File("D:/桌面/All");
        File[] files=file.listFiles();
        System.gc();
        Arrays.stream(files).
                forEach(o->o.delete());
        File file1=new File("D:/桌面/logback.html");
        file1.delete();
        started = true;
    }

    @Override
    public void stop() {
        File file=new File("D:/桌面/All");

        File[] files=file.listFiles();
        System.gc();
        Arrays.stream(files).
                forEach(o->o.delete());
        File file1=new File("D:/桌面/logback.html");
        file1.delete();
    }

    @Override
    public boolean isStarted() {
        return started;
    }

    @Override
    public boolean isResetResistant() {
        return true;
    }

    @Override
    public void onStart( LoggerContext context ) {

    }

    @Override
    public void onReset( LoggerContext context ) {}

    @Override
    public void onStop( LoggerContext context ) {

    }

    @Override
    public void onLevelChange( Logger logger, Level level ) {}


}