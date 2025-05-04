package bionioaio.learn.Other;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * @className: AsynchronousFileChannelDemo
 * @author: wenzhuo4657
 * @date: 2024/4/22 10:02
 * @Version: 1.0
 * @description: 异步通道读取写入buffer
 */
public class AsynchronousFileChannelDemo {
    public static void main(String[] args) {
    }
}

//获得Future的读
class ReadWay1{
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("D:\\学习\\编译\\idea——java\\IoController\\NIO\\src\\5.txt");
        AsynchronousFileChannel asyncFileChannel =
                AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        //创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //读取数据到buffer中
        Future<Integer> future = asyncFileChannel.read(buffer, 0);
        //循环等待，直到读完为⽌，这也是异步的体现
        while(!future.isDone());
        //翻转buffer
        buffer.flip();
        //打印数据
        System.out.println(new String(buffer.array()));
    }
}

//
class ReadWay2{
    public static void main(String[] args) throws IOException, InterruptedException {

        Path path = Paths.get("D:\\学习\\编译\\idea——java\\IoController\\NIO\\src\\4.txt");
        AsynchronousFileChannel asyncFileChannel =
                AsynchronousFileChannel.open(path,  StandardOpenOption.READ);
        //创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        asyncFileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
//           读取成功后调用:注意，由于是异步调用，所以此处不会停留，如果此处线程不去做任何操作，那么线程会结束，也就无法看到该函数的调用
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("result:"+result);
                attachment.flip();
                System.out.println(new String(attachment.array(),0,attachment.limit()));

            }

//            读取失败后调用
            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("失败");

            }
        });

        Thread.sleep(100000l);

    }

}
