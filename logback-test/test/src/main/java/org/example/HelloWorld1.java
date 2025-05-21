package org.example;



import ch.qos.logback.core.net.server.SSLServerSocketAppenderBase;
import com.alibaba.fastjson2.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;


public class HelloWorld1 {
    static class LogMessage {
        String type;
        String level;
        String message;
        long timestamp;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args) throws InterruptedException {

//        日志记录
        LogMessage msg = new LogMessage();
        msg.type = "app_log";
        msg.level = "INFO";
        msg.message = "This is a test log message " ;
        msg.timestamp = System.currentTimeMillis();
        String json = JSON.toJSON(msg).toString();
        Logger logger = LoggerFactory.getLogger(HelloWorld1.class);


        while (true){
            logger.info(json);
            Thread.sleep(1000);

        }


//        logback生命周期访问

//        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//        new StatusPrinter2().print(lc);

    }
}