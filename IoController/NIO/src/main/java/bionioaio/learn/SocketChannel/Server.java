package bionioaio.learn.SocketChannel;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Objects;

/**
 * @className: demo1
 * @author: wenzhuo4657
 * @date: 2024/4/20 13:05
 * @Version: 1.0
 * @description:   ServerSocketChannel阻塞和非阻塞的案例
 */
public class Server{
    public static void main(String[] args)throws  Exception {
        ServerSocketChannel   ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(9090));
        ssc.configureBlocking(false);//ssc.accept()不阻塞，如果没有连接就直接返回null
        while ( true){
            System.out.println("等待连接----");
            SocketChannel socket = ssc.accept();
            if (!Objects.isNull(socket)){
                System.out.println("连接："+socket.getLocalAddress());
                return;
            }

        }
    }
}