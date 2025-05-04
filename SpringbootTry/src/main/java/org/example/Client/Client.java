package org.example.Client;
 
import org.java_websocket.enums.ReadyState;
 
import java.net.URISyntaxException;
 
/**
 * @author lucky_fd
 * @date 2024-1-17
 */
public class Client {
    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        MyWebSocketClient client = new MyWebSocketClient("ws://localhost:22900/websocket/server");
        client.connect();
        while (client.getReadyState() != ReadyState.OPEN) {
            System.out.println("连接状态：" + client.getReadyState());
            Thread.sleep(100);
        }
        client.send("测试数据！");
        client.close();
    }
}