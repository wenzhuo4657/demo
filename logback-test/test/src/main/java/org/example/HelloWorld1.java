package org.example;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class HelloWorld1 {

    public static void main(String[] args) throws InterruptedException {
//        日志记录
        String val1  = "val1";
        Logger logger = LoggerFactory.getLogger("chapters.introduction.HelloWorld1");

            logger.debug("Hello world: {}",val1 );




        logger.debug("Hello world: {}",val1 );

//        logback生命周期访问

//        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//        new StatusPrinter2().print(lc);

    }
}