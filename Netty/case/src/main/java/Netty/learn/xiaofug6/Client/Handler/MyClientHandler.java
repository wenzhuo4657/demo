package Netty.learn.xiaofug6.Client.Handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.EventExecutorGroup;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @className: MyClientHandler
 * @author: wenzhuo4657
 * @date: 2024/4/27 13:23
 * @Version: 1.0
 * @description:
 */
public class MyClientHandler extends ChannelInboundHandlerAdapter {


    @Override

    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        SocketChannel channel = (SocketChannel) ctx.channel();

        System.out.println("链接报告开始");

        System.out.println("链接报告信息：本客户端链接到服务端。channelId：" + channel.id());

        System.out.println("链接报告IP:" + channel.localAddress().getHostString());

        System.out.println("链接报告Port:" + channel.localAddress().getPort());

        System.out.println("链接报告完毕");
        //通知客户端链接建立成功
        String str = "通知服务端链接建立成功" + " " + new Date() + " " + channel.localAddress().getHostString() + "\r\n";

        ctx.writeAndFlush(str);
    }

      /**
         *  des: channnel通道断开连接调用
         * */
    @Override

    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("断开链接" + ctx.channel().localAddress().toString());

    }



    @Override

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        //接收msg消息{与上一章节相比，此处已经不需要自己进行解码}

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息：" + msg);

        //通知客户端链消息发送成功

        ctx.writeAndFlush("客户端收到：" + new Date() + "\r\n");

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


