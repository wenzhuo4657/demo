package bionioaio.learn;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;



public class Server {
    public static void main(String[] args) throws  Exception {
        ServerSocketChannel  ssc=ServerSocketChannel.open();
        ssc.configureBlocking(false);//调整此通道的阻塞模式为非阻塞
        ssc.socket().bind(new InetSocketAddress(9090));//绑定端口号
        Selector selector = Selector.open();
        SelectionKey sscKey = ssc.register(selector, SelectionKey.OP_ACCEPT);
        
        while (true){
            System.out.println("等待事件发生----");
            int select = selector.select();//阻塞执行,轮询监听就绪操作集(两段进行通信操作的数量)已更新的密钥数（可能为零)
            System.out.println("发生事件");
            Set<SelectionKey> selectionKeys=selector.selectedKeys();
            Iterator<SelectionKey> iterator=selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey=iterator.next();
                doTask(selectionKey);
                iterator.remove();
            }

        }


    }

    private static void doTask(SelectionKey selectionKey) throws  Exception{
        if (selectionKey.isAcceptable()){
            System.out.println("服务端执行接受客户端链接----");
            ServerSocketChannel channel=(ServerSocketChannel) selectionKey.channel();
            SocketChannel socketChannel = channel.accept();
            //这里的非阻塞是指 无论channel.accept()连接方法是否阻塞，
            // 但由于selectionKey.isAcceptable()表示此时客户端准备连接,实际上是不阻塞的，或者说正常情况下不阻塞
            socketChannel.configureBlocking(false);
            socketChannel.register(selectionKey.selector(),SelectionKey.OP_READ);//这里直接进行注册，将其设置为读操作类型？
        }else if (selectionKey.isReadable()){
            System.out.println("服务端接受客户端写入数据");
            SocketChannel socketChannel= (SocketChannel) selectionKey.channel();
            ByteBuffer buffer= ByteBuffer.allocate(1024);
            int len=socketChannel.read(buffer);
            /*
            * 此处体现nio非阻塞，对比bio一直停留在此处等待客户端写完，
            * 1，socketChannel.read（）为非阻塞方法，
            * 2，执行到此处说明客户端一定是正在执行写操作
            * 3.线程并不会一直停留在该方法等待读取完成，
            * */
            if (len!=-1){
                System.out.println("读取到客户端数据："+new String(buffer.array(),0,len));
            }
            ByteBuffer byteBuffer =ByteBuffer.wrap("hello nio".getBytes());
            socketChannel.write(byteBuffer);
            selectionKey.interestOps(SelectionKey.OP_READ|SelectionKey.OP_WRITE);//下次连接的操作集，可以是读也可以是写，
        }

    }
}