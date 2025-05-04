package Netty.learn.xiaofug6.Server;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @className: Server
 * @author: wenzhuo4657
 * @date: 2024/4/27 13:11
 * @Version: 1.0
 * @description:
 */
public class Server {
    public static void main(String[] args) {

        new Server().bing(7397);

    }



    private void bing(int port) {

        //配置服务端NIO线程组

        EventLoopGroup parentGroup = new NioEventLoopGroup();

        EventLoopGroup childGroup = new NioEventLoopGroup();

        try {

            ServerBootstrap b = new ServerBootstrap();

            b.group(parentGroup, childGroup)

                    .channel(NioServerSocketChannel.class)    //非阻塞模式

                    .option(ChannelOption.SO_BACKLOG, 128)

                    .childHandler(new MyChannelInitializer());

            ChannelFuture f = b.bind(port).sync();

            System.out.println("Server 启动");

            f.channel().closeFuture().sync();

        } catch (InterruptedException e) {

            e.printStackTrace();

        } finally {

            childGroup.shutdownGracefully();

            parentGroup.shutdownGracefully();

        }

    }
}