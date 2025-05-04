package Netty.learn.HeartBeat;

import Netty.learn.FirstUse1.Handler.MyClientHandler;
import Netty.learn.HeartBeat.Handler.MyClient4Hadnler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Random;

/**
 * @className: Client
 * @author: wenzhuo4657
 * @date: 2024/4/25 13:41
 * @Version: 1.0
 * @description: 随机时间（1-10秒）内向客户端发送心跳消息heartbeat packet
 */
public class Client {
    public static void main(String[] args) {

        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        try {
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {//初始化通道操作
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new MyClient4Hadnler());

                        }
                    });
            System.out.println("客户端启动");
            ChannelFuture sync = b.connect("127.0.0.1", 9090).sync();
            Channel channel = sync.channel();
            String packet="heartbeat packet";
            Random random = new Random();
            while (channel.isActive()){
                int num=random.nextInt(10);
                Thread.sleep(1*1000);
                channel.writeAndFlush(packet);
            }
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            group.shutdownGracefully();
        }


    }
}