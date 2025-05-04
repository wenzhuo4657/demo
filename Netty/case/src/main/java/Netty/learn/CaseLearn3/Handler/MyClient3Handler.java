package Netty.learn.CaseLearn3.Handler;

import Netty.learn.CaseLearn3.MessageProtocol;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

import java.nio.charset.StandardCharsets;

/**
 * @className: MyClient3Handler
 * @author: wenzhuo4657
 * @date: 2024/4/25 10:46
 * @Version: 1.0
 * @description: 客户端业务处理器
 */
public class MyClient3Handler extends SimpleChannelInboundHandler<MessageProtocol> {

//    感知到通道建立调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for ( int i=0;i<200;i++){
            String msg="这里是客户端！！";
            MessageProtocol protocol =new MessageProtocol();
            byte [] data=msg.getBytes(StandardCharsets.UTF_8);
            protocol.setLength(data.length);
            protocol.setContent(data);
            ctx.writeAndFlush(protocol);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}