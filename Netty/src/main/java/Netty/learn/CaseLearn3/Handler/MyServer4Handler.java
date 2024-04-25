package Netty.learn.CaseLearn3.Handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @className: MyServer4Handler
 * @author: wenzhuo4657
 * @date: 2024/4/25 13:56
 * @Version: 1.0
 * @description:
 */
public class MyServer4Handler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

    }
}