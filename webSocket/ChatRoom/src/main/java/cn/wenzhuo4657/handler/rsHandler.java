package cn.wenzhuo4657.handler;

import cn.wenzhuo4657.domain.SessionBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @className: rsHandler
 * @author: wenzhuo4657
 * @date: 2024/4/9 20:35
 * @Version: 1.0
 * @description:rs1的连接处理
 */

@Component
@Slf4j
public class rsHandler extends AbstractWebSocketHandler{
    private static final Map<String , SessionBean> sessionBeanMap;
    private static AtomicInteger clientIdMaker;//线程安全的Integer

    private  static  StringBuilder stringBuilder;//聊天上下文
    static {
        sessionBeanMap=new ConcurrentHashMap<>();
        clientIdMaker=new AtomicInteger(0);
        stringBuilder=new StringBuilder();
    }
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        SessionBean sessionBean=new SessionBean(session,clientIdMaker.getAndIncrement());
        sessionBeanMap.put(session.getId(),sessionBean);
        log.info(sessionBeanMap.get(session.getId()).getClientId()+"建立了连接");
        stringBuilder.append(sessionBeanMap.get(session.getId()).getClientId()+"进入了群聊<br/>");
        sendMessage(sessionBeanMap);
    }
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        log.info(sessionBeanMap.get(session.getId()).getClientId()+"发送消息:"+message.getPayload());
        stringBuilder.append(sessionBeanMap.get(session.getId()).getClientId()+":"+message.getPayload()+"<br/>");
        sendMessage(sessionBeanMap);

    }
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
        if (session.isOpen()){
            session.close();
        }
        sessionBeanMap.remove(session.getId());
        log.info(sessionBeanMap.get(session.getId()).getClientId()+"连接出错");
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        int clientId = sessionBeanMap.get(session.getId()).getClientId();
        log.info(clientId+"关闭了连接");
        stringBuilder.append(clientId+"退出了群聊<br/>");
        sendMessage(sessionBeanMap);
        sessionBeanMap.remove(session);
    }


    public void sendMessage(Map<String,SessionBean> sessionBeanMap){
        for(String key:sessionBeanMap.keySet()){
            try {
                sessionBeanMap.get(key).getWebSocketSession().sendMessage(new TextMessage(stringBuilder.toString()));
            } catch (IOException e) {
//                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
    }
}