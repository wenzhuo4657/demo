package bionioaio.learn;

/**
 * @className: Server
 * @author: wenzhuo4657
 * @date: 2024/4/22 10:48
 * @Version: 1.0
 * @description:
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        //创建异步的Server Socket Channel
        AsynchronousServerSocketChannel serverSocketChannel =
                AsynchronousServerSocketChannel.open();
        //绑定端⼝
        serverSocketChannel.bind(new InetSocketAddress(9001));
        //异步接收
        serverSocketChannel.accept(null, new
                CompletionHandler<AsynchronousSocketChannel, Object>() {
                    /**
                     * 当有连接发⽣时调⽤的⽅法
                     */
                    @Override
                    public void completed(AsynchronousSocketChannel
                                                  socketChannel, Object attachment) {
                        try {
                            //开启接收
                            serverSocketChannel.accept(attachment,this);
                            System.out.println("消息来⾃ 于："+socketChannel.getRemoteAddress());
                                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                            socketChannel.read(buffer, buffer, new
                                    CompletionHandler<Integer, ByteBuffer>() {
                                        @Override
                                        public void completed(Integer result,
                                                              ByteBuffer byteBuffer) {
                                            byteBuffer.flip();
                                            //打印收到的消息
                                            System.out.println(new
                                                    String(buffer.array(),0,result));
                                            //向客户端返回消息

                                            socketChannel.write(ByteBuffer.wrap("hello client".getBytes()));

                                        }
                                        @Override
                                        public void failed(Throwable exc,
                                                           ByteBuffer attachment) {
                                        }
                                    });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    /**
                     * 当连接失败时调⽤的⽅法
                     */
                    @Override
                    public void failed(Throwable exc, Object attachment) {
                    }
                });
        System.out.println("main thread");
        Thread.sleep(Integer.MAX_VALUE);
    }
}