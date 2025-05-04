package Netty.learn.FirstUse1;

import Netty.learn.FirstUse1.Handler.MyClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


/**
 * @className: Client
 * @author: wenzhuo4657
 * @date: 2024/4/22 16:55
 * @Version: 1.0
 * @description:
 */
public class Client {
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
    try {
        b.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast( new MyClientHandler());
                    }
                });
        System.out.println("客户端启动");
        ChannelFuture sync = b.connect("127.0.0.1", 9090).sync();
        sync.channel().closeFuture().sync();
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }finally {
        group.shutdownGracefully();
    }


    }

}