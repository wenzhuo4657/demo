package Netty.learn.HeartBeat.Handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @className: MyServer4Handler
 * @author: wenzhuo4657
 * @date: 2024/4/25 13:56
 * @Version: 1.0
 * @description:
 */
public class MyServer4Handler extends SimpleChannelInboundHandler<String> {
    int readidle=0;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        readidle=0;
        System.out.println("客户端："+msg);
        ctx.writeAndFlush("yes");
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        IdleStateEvent event = (IdleStateEvent)evt;
        switch (event.state()){
            case  READER_IDLE:
                readidle++;
                System.out.println("读超时");
                break;
            case WRITER_IDLE:
                    System.out.println("写超时");
                    break;
            case ALL_IDLE:
                System.out.println("读写超时");
        }

        if (readidle>3){
            readidle=0;
            System.out.println("超时关闭！！");
            ctx.channel().close();
        }
    }
}