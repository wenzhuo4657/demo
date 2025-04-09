package Netty.learn.CaseLearn2;


import Netty.learn.CaseLearn2.Handler.MyClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @className: Client
 * @author: wenzhuo4657
 * @date: 2024/4/23 19:27
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
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(new MyClientHandler());
                        }
                    });
            System.out.println("客户端启动");
            ChannelFuture sync = b.connect("127.0.0.1", 9090).sync();
            Channel channel = sync.channel();
            Scanner sc=new Scanner(System.in);
            while (sc.hasNextLine()){
                String msg = sc.nextLine();
                channel.writeAndFlush(msg);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            group.shutdownGracefully();
        }


    }

}