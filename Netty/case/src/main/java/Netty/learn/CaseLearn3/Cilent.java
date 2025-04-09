package Netty.learn.CaseLearn3;

import Netty.learn.CaseLearn3.Handler.MyClient3Encoder;
import Netty.learn.CaseLearn3.Handler.MyClient3Handler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @className: Cilent
 * @author: wenzhuo4657
 * @date: 2024/4/25 10:37
 * @Version: 1.0
 * @description:
 */
public class Cilent  {

    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup(1);
        Bootstrap bootstrap = new Bootstrap();

        try {
            bootstrap.group(group).
                    channel(NioSocketChannel.class).
                    handler(new ChannelInitializer<SocketChannel>(){
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new MyClient3Encoder());
                            pipeline.addLast(new MyClient3Handler());
                        }
                    });
            ChannelFuture sync = bootstrap.connect("127.0.0.1", 9090).sync();
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            group.shutdownGracefully();
        }

    }
}