package Netty.learn.FirstUse1.Handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;

/**
 * @className: MyIOHandler
 * @author: wenzhuo4657
 * @date: 2024/4/22 17:44
 * @Version: 1.0
 * @description:
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {
//    客户端发送来数据时调用
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

//        ByteBuf是对ByteBuffer的封装
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端："+buf.toString(StandardCharsets.UTF_8));//解码
    }

//   读取完成后调用，就是响应
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buf= Unpooled.copiedBuffer("hello Client!!".getBytes(StandardCharsets.UTF_8));
        ctx.writeAndFlush(buf);//出站逻辑
    }

//    出现异常时调用
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
        ctx.close();
    }



}