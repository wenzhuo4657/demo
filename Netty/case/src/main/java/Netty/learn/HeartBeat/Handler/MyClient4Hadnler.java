package Netty.learn.HeartBeat.Handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @className: MyClient4Hadnler
 * @author: wenzhuo4657
 * @date: 2024/4/25 13:43
 * @Version: 1.0
 * @description:
 */
public class MyClient4Hadnler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("客户端收到的数据："+msg);
    }
}