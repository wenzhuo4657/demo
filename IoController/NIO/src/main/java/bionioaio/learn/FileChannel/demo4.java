package bionioaio.learn.FileChannel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @className: demo4
 * @author: wenzhuo4657
 * @date: 2024/4/20 12:40
 * @Version: 1.0
 * @description: 设置通道总大小，：如果此通道的文件位置大于给定大小，则将其设置为该大小，多余字节会被截断和丢弃，这会改变文件本身
 * 且注意，该方法在当前语句生效，并非永久性的限制文件大小，如果后续执行写入操作大于当前设置大小，会自然的拓展文件大小
 */
public class demo4 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file=new RandomAccessFile("D:\\学习\\编译\\idea——java\\IoController\\NIO\\src\\2.txt","rw");
        FileChannel fileChannel =file.getChannel();
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        fileChannel.truncate(5);
    }
}