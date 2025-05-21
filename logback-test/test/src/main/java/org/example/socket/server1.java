package org.example.socket;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.net.server.ServerSocketAppender;
import ch.qos.logback.classic.net.server.ServerSocketReceiver;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CountDownLatch;

/**
 * 日志服务器： 接收日志
 */
public class server1 {

    public static void main(String[] args) throws InterruptedException, IOException {
        String host="127.0.0.1";
        int port=8081;

        ServerSocketReceiver myserver = new ServerSocketReceiver();
        myserver.setAddress(host);
        myserver.setPort(port);


        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        myserver.setContext(lc);
        myserver.start();

        new CountDownLatch(1).await();

    }
}
