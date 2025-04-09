package bionioaio.learn.Buffer;

import java.io.*;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @className: demo3
 * @author: wenzhuo4657
 * @date: 2024/4/21 13:30
 * @Version: 1.0
 * @description:
 * 直接缓冲区：jvm会尽量对其直接执行本机的IO操作;
 * jvm会尝试避免每次调用io操作前后将缓冲区内容复制到中间缓冲区
 */
public class demo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream in1 = new FileInputStream("D:\\学习\\编译\\idea——java\\IoController\\NIO\\src\\1.txt");
        FileChannel channel1 = in1.getChannel();
        FileOutputStream out = new FileOutputStream("D:\\学习\\编译\\idea——java\\IoController\\NIO\\src\\5.txt");
        FileChannel channel2 = out.getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);//直接缓冲区
        int len=0;
        while ((len=channel1.read(buffer))>0){
            buffer.flip();
            channel2.write(buffer);
        }

    }
}