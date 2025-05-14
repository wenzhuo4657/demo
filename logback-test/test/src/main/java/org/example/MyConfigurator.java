package org.example;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.classic.layout.TTLLLayout;
import ch.qos.logback.classic.spi.Configurator;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.LogbackException;
import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.util.Loader;
import ch.qos.logback.core.util.StatusPrinter2;

import java.net.URL;

public class MyConfigurator  extends ContextAwareBase implements Configurator {



    private  String configFile="logback-spring.xml";
    @Override
    public ExecutionStatus configure(LoggerContext context) {

//        1,logback自定义的类加载器，从加载角度上来说似乎是为了避免冲突，此处不去深究
        ClassLoader myClassLoader = Loader.getClassLoaderOfObject(this);

        URL resource = getResource(configFile, myClassLoader);

        if(resource==null){
            return  ExecutionStatus.INVOKE_NEXT_IF_ANY;  //寻找其他
        }
        try {
            configureByResource(resource);
        } catch (JoranException e) {
            throw new RuntimeException(e);

        }

        addInfo("自定义配置: logback-spring.xml 加载成功，");
        return ExecutionStatus.DO_NOT_INVOKE_NEXT_IF_ANY;   //停止寻找其他

    }

    private URL getResource(String filename, ClassLoader myClassLoader) {
        URL url = Loader.getResource(filename, myClassLoader);
        return url;
    }


    public void configureByResource(URL url) throws JoranException {
        if (url == null) {
            throw new IllegalArgumentException("URL argument cannot be null");
        }
        final String urlString = url.toString();
        if (urlString.endsWith("xml")) {
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(context);
            configurator.doConfigure(url);
        } else {
            throw new LogbackException(
                    "Unexpected filename extension of file [" + url.toString() + "]. Should be .xml");
        }
    }
}
