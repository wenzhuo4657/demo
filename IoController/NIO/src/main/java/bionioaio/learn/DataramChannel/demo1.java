package bionioaio.learn.DataramChannel;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @className: demo
 * @author: wenzhuo4657
 * @date: 2024/4/20 14:17
 * @Version: 1.0
 * @description: 接收、发送数据
 */
public class demo1{
    @Test
    public void SendCannel() throws IOException {
        DatagramChannel channel=DatagramChannel.open();
        InetSocketAddress addr = new InetSocketAddress("127.0.0.1",9001);
        ByteBuffer buffer =ByteBuffer.allocate(1024);
        buffer.put("hello!!".getBytes());
        buffer.flip();
        channel.send(buffer,addr);
    }

    @Test
    public void  ReceptionCannel() throws IOException {
        DatagramChannel ch = DatagramChannel.open();
        InetSocketAddress addr = new InetSocketAddress(9001);
        ch.bind(addr);
        ByteBuffer buffer =  ByteBuffer.allocate(1024);
        while(true){
            buffer.clear();
            SocketAddress address=ch.receive(buffer);
            buffer.flip();
            System.out.println(address.toString()+"消息内容："+new String(buffer.array(),0,buffer.limit()));
        }
    }

}