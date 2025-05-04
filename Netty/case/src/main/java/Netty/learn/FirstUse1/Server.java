package Netty.learn.FirstUse1;

import Netty.learn.FirstUse1.Handler.MyServerHandler;
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
 * @date: 2024/4/22 16:54
 * @Version: 1.0
 * @description:
 */

public class Server {
    public static void main(String[] args) {
//        处理连接端请求
        EventLoopGroup AccoptGroup = new NioEventLoopGroup(10);
//        处理读写业务
        EventLoopGroup WorkGroup = new NioEventLoopGroup(10);

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(AccoptGroup, WorkGroup)//设置group
                    .channel(NioServerSocketChannel.class)//设置通道
                    .option(ChannelOption.SO_BACKLOG,1024)    //设置用于存放由于没有空闲线程的导致客户端连接暂存至队列的长度
                    .childHandler(new ChannelInitializer<SocketChannel>(){
                                      @Override
                                      protected void initChannel(SocketChannel ch) throws Exception {
                                          ChannelPipeline pipeline = ch.pipeline();
                                          pipeline.addLast(new StringDecoder());//解码，入站
                                          pipeline.addLast(new StringEncoder());//编码，出站，
                                          pipeline.addLast( new MyServerHandler());
                                      }
                                  }
                            );
            System.out.println("netty启动");
//            sync():前面的操作未结束，就一直阻塞
            ChannelFuture sync = serverBootstrap.bind(9090).sync();
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
             AccoptGroup.shutdownGracefully();
             WorkGroup.shutdownGracefully();
        }


    }
}