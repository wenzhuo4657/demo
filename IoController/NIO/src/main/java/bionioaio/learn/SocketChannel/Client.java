package bionioaio.learn.SocketChannel;

import bionioaio.learn.Utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @className: Client
 * @author: wenzhuo4657
 * @date: 2024/4/20 13:06
 * @Version: 1.0
 * @description: SocketChanne阻塞和非阻塞的案例
 */
public class Client {

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("www.baidu.com", 80));
        channel.configureBlocking(false);
        channel.setOption(StandardSocketOptions.SO_RCVBUF,1024);//套接字接收缓冲区的大小
        channel.setOption(StandardSocketOptions.SO_SNDBUF,1024);//套接字发送缓冲区的大小
        if (channel.isConnectionPending()){
            channel.finishConnect();
        }
        ByteBuffer bb = ByteBuffer.allocate(1024);
        int len=channel.read(bb);
        switch (len){
            case  0:
                Utils.println("\n读取失败");break;
            case -1:
                Utils.println("\n读取结束");break;
            default:
                Utils.println(new String(bb.array(),0,len));
        }
    }


}