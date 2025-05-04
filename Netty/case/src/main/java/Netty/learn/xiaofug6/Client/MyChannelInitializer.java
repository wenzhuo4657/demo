package Netty.learn.xiaofug6.Client;

import Netty.learn.xiaofug6.Client.Handler.MyClientHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;

/**
 * @className: MyChannelInitializer
 * @author: wenzhuo4657
 * @date: 2024/4/27 13:13
 * @Version: 1.0
 * @description:  通道初始化配置，
 * 1，新链接建立调用
 * 2，ChannelPipeline初始化调用
 *
 * 除了该种方式也可以使用匿名内部类的方式调用，
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline().addLast(new LineBasedFrameDecoder(1024));

        channel.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));

        channel.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));

        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MyClientHandler());

    }


}