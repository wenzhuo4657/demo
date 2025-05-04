package org.example.Client;
 
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
 
import java.net.URI;
import java.net.URISyntaxException;
 
public class MyWebSocketClient extends WebSocketClient {
 
    MyWebSocketClient(String url) throws URISyntaxException {
        super(new URI(url));
    }
   // 建立连接
    @Override
    public void onOpen(ServerHandshake shake) {
        System.out.println(shake.getHttpStatusMessage());
    }
   // 接收消息
    @Override
    public void onMessage(String paramString) {
        System.out.println(paramString);
    }
   // 关闭连接
    @Override
    public void onClose(int paramInt, String paramString, boolean paramBoolean) {
        System.out.println("关闭");
    }
   // 连接异常
    @Override
    public void onError(Exception e) {
        System.out.println("发生错误");
    }
}