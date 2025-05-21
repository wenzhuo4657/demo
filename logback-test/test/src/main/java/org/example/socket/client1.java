package org.example.socket;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.html.HTMLLayout;
import ch.qos.logback.classic.net.SocketAppender;
import ch.qos.logback.classic.net.server.ServerSocketAppender;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 客户端： 发送日志到服务器
 */
public class client1 {

    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 8081;

        SocketAppender myclient = new SocketAppender();
        myclient.setRemoteHost(host);
        myclient.setPort(port);
        myclient.setName("myclient");


        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        myclient.setContext(lc);

        myclient.start();



        Logger logger = (Logger) LoggerFactory.getLogger(client1.class);
        logger.addAppender(myclient);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Please input:");
            String s = reader.readLine();

            if (s.equals("q")) {
                break;
            } else {
                logger.info(s);
            }
        }

    }
}
