package Netty.learn.xiaofug6.Client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @className: Client
 * @author: wenzhuo4657
 * @date: 2024/4/27 13:11
 * @Version: 1.0
 * @description:
 */
public class Client {

    public static void main(String[] args) {

        new Client().connect("127.0.0.1", 7397);

    }



    private void connect(String inetHost, int inetPort) {

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {

            Bootstrap b = new Bootstrap();

            b.group(workerGroup);

            b.channel(NioSocketChannel.class);

            b.option(ChannelOption.AUTO_READ, true);

            b.handler(new MyChannelInitializer());//注意此处，该类中定义pinpline，

            ChannelFuture f = b.connect(inetHost, inetPort).sync();

            System.out.println("这里是客户端！！！");

            f.channel().closeFuture().sync();

        } catch (InterruptedException e) {

            e.printStackTrace();

        } finally {

            workerGroup.shutdownGracefully();

        }

    }
}