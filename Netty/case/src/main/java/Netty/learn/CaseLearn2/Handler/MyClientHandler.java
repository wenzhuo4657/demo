package Netty.learn.CaseLearn2.Handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @className: MyClientHandler
 * @author: wenzhuo4657
 * @date: 2024/4/23 19:27
 * @Version: 1.0
 * @description:
 */

public class MyClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg.trim());


    }
}