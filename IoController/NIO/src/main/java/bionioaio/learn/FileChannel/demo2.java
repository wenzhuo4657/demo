package bionioaio.learn.FileChannel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @className: demo2
 * @author: wenzhuo4657
 * @date: 2024/4/20 12:05
 * @Version: 1.0
 * @description: FileChannel写数据
 */
public class demo2 {


    public static void main(String[] args) throws  Exception {
        RandomAccessFile file=new RandomAccessFile("D:\\学习\\编译\\idea——java\\IoController\\NIO\\src\\2.txt","rw");
        FileChannel channel=file.getChannel();
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        String txt="hello file channel";
        buffer.put(txt.getBytes());
        buffer.flip();
        channel.write(buffer);
        channel.close();
    }

}