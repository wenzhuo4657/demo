package bionioaio.learn;

/**
 * @className: Client
 * @author: wenzhuo4657
 * @date: 2024/4/22 10:48
 * @Version: 1.0
 * @description:
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;


public class Client {
    public static void main(String[] args) throws Exception {
        AsynchronousSocketChannel socketChannel =
                AsynchronousSocketChannel.open();
        //调⽤get⽅法完成连接
        socketChannel.connect(new
                InetSocketAddress("127.0.0.1",9001)).get();
        //发送数据
        socketChannel.write(ByteBuffer.wrap("hello server".getBytes()));
                //获得返回的数据
                ByteBuffer buffer = ByteBuffer.allocate(1024);
        int len = 0;
        //调⽤get⽅法实现同步
        while((len = socketChannel.read(buffer).get())>0){
            System.out.println("服务端返回的消息："+new
                    String(buffer.array(),0,len));
        }
    }
}