package bionioaio.learn.FileChannel;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @className: demo3
 * @author: wenzhuo4657
 * @date: 2024/4/20 12:27
 * @Version: 1.0
 * @description:  不同Filechannel之间直接传输，不用先读再写
 */
public class demo3 {
    public static void main(String[] args) throws  Exception {
        RandomAccessFile rootfile=new RandomAccessFile("D:\\学习\\编译\\idea——java\\IoController\\NIO\\src\\1.txt","rw");
        FileChannel rootChannel=rootfile.getChannel();
        RandomAccessFile targetfile=new RandomAccessFile("D:\\学习\\编译\\idea——java\\IoController\\NIO\\src\\3.txt","rw");
        FileChannel targetChannel=targetfile.getChannel();

//rootChannel-->targetfile
        targetChannel.transferFrom(rootChannel,0,rootChannel.size());
//        targetfile-->rootChannel
        targetChannel.transferTo(0,targetChannel.size(),rootChannel);
        rootfile.close();
        targetChannel.close();
    }
}