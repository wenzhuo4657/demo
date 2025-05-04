package bionioaio.learn.Other;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;

/**
 * @className: FileLockDemo
 * @author: wenzhuo4657
 * @date: 2024/4/21 15:02
 * @Version: 1.0
 * @description:
 */
public class FileLockDemo1 {
    public static void main(String[] args) throws Exception {
        File file=new File("D:\\学习\\编译\\idea——java\\IoController\\NIO\\src\\1.txt");
        FileOutputStream fos =  new FileOutputStream(file);
        FileChannel fileChannel =fos.getChannel();
        FileLock lock = fileChannel.lock();
        Thread.sleep(100L);
        lock.release();
    }
}


class  FileLock1{
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\学习\\编译\\idea——java\\IoController\\NIO\\src\\1.txt");
        FileOutputStream fos =  new FileOutputStream(file);
        FileChannel fileChannel =fos.getChannel();
        FileLock lock = fileChannel.lock();
    }

}