package bionioaio.learn.ScatterAndGather;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @className: ScatterDemo
 * @author: wenzhuo4657
 * @date: 2024/4/20 15:40
 * @Version: 1.0
 * @description:
 * 从一个channel中读取多个buffer，且注意，只有将上一个buffer读满了，才能更换buffer读取
 */
public class ScatterDemo {

    public static void main(String[] args) throws IOException {
        RandomAccessFile file=new RandomAccessFile("E:\\code\\java\\idea\\try\\IoController\\NIO\\src\\4.txt","rw");
        FileChannel fileChannel =file.getChannel();
        ByteBuffer buffer1=ByteBuffer.allocate(5);
        ByteBuffer buffer2=ByteBuffer.allocate(1024);
        ByteBuffer[] buffer=new ByteBuffer[]{buffer1, buffer2};
        long len=0;
        while ( (len=fileChannel.read(buffer)) !=-1){
            buffer1.flip();
            buffer2.flip();
            System.out.println("buffer1"+new String(buffer1.array(),0,buffer1.limit()));
            System.out.println("buffer2"+new String(buffer2.array(),0,buffer2.limit()));

        }
    }

}