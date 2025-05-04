package Netty.learn.CaseLearn3.Handler;

import Netty.learn.CaseLearn3.MessageProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.StandardCharsets;

/**
 * @className: MyServer3Handler
 * @author: wenzhuo4657
 * @date: 2024/4/25 13:23
 * @Version: 1.0
 * @description:
 */
public class MyServer3Handler extends SimpleChannelInboundHandler<MessageProtocol> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        System.out.println("服务端受到消息--");
        System.out.println("消息长度："+msg.getLength());
        System.out.println("消息内容："+new String( msg.getContent(), StandardCharsets.UTF_8));
    }
}