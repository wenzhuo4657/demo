package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class host1 {
    public static void main(String[] args) throws IOException {



        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 9090));


        Selector open = Selector.open();
        SelectionKey register = serverSocketChannel.register(open, SelectionKey.OP_READ);




        while (true) {
            // 接受客户端连接
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("Accepted connection from " + socketChannel.getRemoteAddress());
            // 处理客户端连接
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int read = socketChannel.read(buffer);
            while (read>0) {
                // 重置 buffer 的位置以便读取数据
                buffer.flip();

                ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

                // 从 buffer 中读取数据并打印
                while (buffer.hasRemaining()) {
                    byteBuffer.put(buffer.get());
                }
                System.out.println(new String(byteBuffer.array()));

                // 清空 buffer 以便下一次读取
                buffer.clear();

                // 再次从 SocketChannel 读取数据


                    read= socketChannel.read(buffer);

            }
        }

        }



}