package bionioaio.learn;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @className: Cilent
 * @author: wenzhuo4657
 * @date: 2024/4/18 11:48
 * @Version: 1.0
 * @description:
 */
public class Cilent {
    public static void main(String[] args) throws  Exception{
        SocketChannel channel=SocketChannel.open();
            channel.configureBlocking(false);
        Selector selector=Selector.open();
        //此处连接到服务端将注册channel到ServerSocketChannel中，会更新selector.select()结果
        channel.connect(new InetSocketAddress("127.0.0.1",9090));
        channel.register(selector, SelectionKey.OP_CONNECT);//注册本地的Selector复用器
        while (true){
            selector.select();//客户端角度恒为1，只有一个通道连接想服务端
            Iterator <SelectionKey> iterator=selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                SelectionKey key=iterator.next();
                handle(key);
                iterator.remove();
            }
        }

    }

    private static void handle(SelectionKey key) throws IOException {
        SocketChannel socketChannel=(SocketChannel) key.channel();
        if (key.isConnectable()){
            if (socketChannel.isConnectionPending()){
                socketChannel.finishConnect();
                socketChannel.configureBlocking(false);
                ByteBuffer buffer=ByteBuffer.wrap("hello server".getBytes());
                socketChannel.write(buffer);//会更新selector.select()结果
                socketChannel.register(key.selector(),SelectionKey.OP_READ);
            }
        }else if (key.isReadable()){
            ByteBuffer buffer=ByteBuffer.allocate(1024);
            int  len=socketChannel.read(buffer);
            if (len!=-1){
                System.out.println("服务器端返回的数据是："+new String(buffer.array(),0,len));
            }

        }



    }


}