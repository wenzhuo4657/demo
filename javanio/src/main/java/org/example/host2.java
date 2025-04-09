package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @author: wenzhuo4657
 * @date: 2025/2/15
 * @description:
 */
public class host2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel channel = SocketChannel.open();

        channel.connect(new InetSocketAddress("localhost", 9090));
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        buffer.put("131231".getBytes());
        buffer.flip();
//        while (buffer.hasRemaining()) {
            channel.write(buffer);
//        }
        new CountDownLatch(1).await();



    }
}
