package Netty.learn.xiaofug6.Server.Handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;

import java.text.SimpleDateFormat;
import  java.util.Date;
/**
 * @className: MyServerHandler
 * @author: wenzhuo4657
 * @date: 2024/4/27 13:33
 * @Version: 1.0
 * @description:
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override

    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        SocketChannel channel = (SocketChannel) ctx.channel();

        System.out.println("链接报告开始");

        System.out.println("链接报告信息：有一客户端链接到本服务端");

        System.out.println("链接报告IP:" + channel.localAddress().getHostString());

        System.out.println("链接报告Port:" + channel.localAddress().getPort());

        System.out.println("链接报告完毕");

        //通知客户端链接建立成功

        String str = "通知客户端链接建立成功" + " " + new Date() + " " + channel.localAddress().getHostString() + "\r\n";

        ByteBuf buf = Unpooled.buffer(str.getBytes().length);

        buf.writeBytes(str.getBytes("GBK"));

        ctx.writeAndFlush(buf);

    }



    /**

     * 当客户端主动断开服务端的链接后，这个通道就是不活跃的。也就是说客户端与服务端的关闭了通信通道并且不可以传输数据

     */

    @Override

    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("客户端断开链接" + ctx.channel().localAddress().toString());

    }



    @Override

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        //接收msg消息

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息：" + msg);

        //通知客户端链消息发送成功

        ctx.writeAndFlush("服务端收到：" + new Date() + "\r\n");

    }



    /**

     * 抓住异常，当发生异常的时候，可以做一些相应的处理，比如打印日志、关闭链接

     */

    @Override

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        ctx.close();

        System.out.println("异常信息：\r\n" + cause.getMessage());

    }


}