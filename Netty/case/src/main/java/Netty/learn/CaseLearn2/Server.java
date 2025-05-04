package Netty.learn.CaseLearn2;

import Netty.learn.CaseLearn2.Handler.MyServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @className: Server
 * @author: wenzhuo4657
 * @date: 2024/4/23 18:52
 * @Version: 1.0
 * @description:
 */
public class Server {
    public static void main(String[] args) {
        EventLoopGroup AccoptGroup = new NioEventLoopGroup(10);
        EventLoopGroup WorkGroup = new NioEventLoopGroup(10);
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(AccoptGroup, WorkGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChannelInitializer<SocketChannel>(){

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(new MyServerHandler());
                        }
                    });
            System.out.println("服务端启动");
            ChannelFuture sync = b.bind(9090).sync();
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            AccoptGroup.shutdownGracefully();
            WorkGroup.shutdownGracefully();
        }
    }
}