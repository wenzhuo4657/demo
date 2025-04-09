package cn.wenzhuo4657.echo.server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @className: echoServer
 * @author: wenzhuo4657
 * @date: 2024/4/2 14:07
 * @Version: 1.0
 * @description:  监听客服端连接
 */

@ServerEndpoint(value = "/rs")
@Component
public class echoServer  implements ApplicationContextAware {
    private Logger logger= LoggerFactory.getLogger(echoServer.class);
;
    private Session session;

    private static ApplicationContext applicationContext;//可以这个属性连接spring容器，操作bean的注入等，
    private String userId;
//    客户端连接存储：可通过session向客户端操作
    private static ConcurrentHashMap<String,Session> sessionPool = new ConcurrentHashMap<String,Session>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        echoServer.applicationContext = applicationContext;
    }




    //执行一些初始化工作，每个实例仅执行一次
    @OnOpen
    public  void open(Session session){
        this.session=session;
        this.userId=session.getId();
        sessionPool.put(userId,session);


//        useService=echoServer.applicationContext.getBean(useService.class);
//        useService.start();
        logger.info("[websocket] 新的连接：id={}", this.session.getId());
//        logger.info("[websocket] 用户id={}",userId);
    }

    @OnClose
    public  void    onclose(){
        sessionPool.remove(userId);
        logger.info("[websocket] 连接关闭 用户id={}",userId);
    }


    @OnError
    public void onError(Throwable error) {

        logger.error("用户错误,原因:"+error.getMessage());
        error.printStackTrace();
    }

    @OnMessage
    public  String onMessage(String text){
        logger.info("已收到：{}",text);
        return "收到";
    }

    @Scheduled(fixedRate = 2000)
    public  void sendMsg() throws IOException {
        for (Session session:sessionPool.values()){
                session.getBasicRemote().sendText("心跳");
        }

    }
}