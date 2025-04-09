package Netty.learn.FirstUse1.Handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;

/**
 * @className: MyClientHandler
 * @author: wenzhuo4657
 * @date: 2024/4/22 18:20
 * @Version: 1.0
 * @description:
 */
public class MyClientHandler extends ChannelInboundHandlerAdapter {

//    连接完成后调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buf= Unpooled.copiedBuffer("hello Server!!".getBytes(StandardCharsets.UTF_8));//编码
        ctx.writeAndFlush(buf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf是对ByteBuffer的封装
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("服务端："+buf.toString(StandardCharsets.UTF_8));
    }




}