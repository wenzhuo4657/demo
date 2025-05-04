package bionioaio.learn.Buffer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @className: demo4
 * @author: wenzhuo4657
 * @date: 2024/4/21 13:53
 * @Version: 1.0
 * @description: MappedByteBuffer:将磁盘文件内容映射到虚拟内存中，无需通过io流读写，效率极高
 */
public class demo4 {
    public static void main(String[] args) throws Exception {
        File file=new File("D:\\学习\\编译\\idea——java\\IoController\\NIO\\src\\1.txt");
        RandomAccessFile file1=new RandomAccessFile(file,"rw");
        FileChannel fileChannel =file1.getChannel();
        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,0,file1.length());
        while (buffer.hasRemaining()){
            System.out.print((char)buffer.get()+"\t");
        }
    }
}