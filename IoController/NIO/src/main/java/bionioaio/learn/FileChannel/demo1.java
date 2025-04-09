package bionioaio.learn.FileChannel;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/**
 * @className: client
 * @author: wenzhuo4657
 * @date: 2024/4/18 19:02
 * @Version: 1.0
 * @description: FileChannel读数据
 */
public class demo1 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file=new RandomAccessFile("D:\\学习\\编译\\idea——java\\IoController\\NIO\\src\\1.txt","rw");
        FileChannel fileChannel =file.getChannel();
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        int len=0;
        while ( (len=fileChannel.read(buffer)) !=-1){
            buffer.flip();// limit = position;position = 0;
            while (buffer.hasRemaining()){//position < limit
                byte b= buffer.get();//获取 position 位置, position++
                System.out.println((char) b);
            }
            buffer.clear();// position = 0;limit = capacity;
        }



    }

}