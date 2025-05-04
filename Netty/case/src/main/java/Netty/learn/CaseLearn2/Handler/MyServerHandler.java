package Netty.learn.CaseLearn2.Handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @className: MyServerHandler
 * @author: wenzhuo4657
 * @date: 2024/4/23 18:52
 * @Version: 1.0
 * @description: SimpleChannelInboundHandler:该api会自动释放资源
 * 自动资源管理：SimpleChannelInboundHandler 自动处理 ByteBuf 的引用计数释放。
 * 当 channelRead0() 方法返回时，若 msg 是 ByteBuf 或其子类，会自动调用 release() 方法释放资源，减轻了开发者的内存管理负担。
 * 源码：
 *     @Override
 *     public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
 *         boolean release = true;
 *         try {
 *             if (acceptInboundMessage(msg)) {
 *                 @SuppressWarnings("unchecked")
 *                 I imsg = (I) msg;
 *                 channelRead0(ctx, imsg);//注意此处
 *             } else {
 *                 release = false;
 *                 ctx.fireChannelRead(msg);
 *             }
 *         } finally {
 *             if (autoRelease && release) {
 *                 ReferenceCountUtil.release(msg);//注意此处
 *             }
 *         }
 *     }
 */


public class MyServerHandler extends SimpleChannelInboundHandler<String> {
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");


    private  static ChannelGroup group=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);



//    客户端连接时调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        String msg=print(channel,"上线了" ,new Date());
        group.writeAndFlush(msg);//向其他已连接的客户端广播
        group.add(channel);
    }
//   客户端连接断开时调用
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        String msg = print(channel,"下线了",new Date());
        group.writeAndFlush(msg);
        group.remove(channel);
    }


//  读取完客户端发送的信息msg后调用
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel fal=ctx.channel();
        group.forEach(o->{
            if (!fal.equals(o)){
                o.writeAndFlush(print(o,msg,new Date()));
            }
        });

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private String print(Channel channel, String text
            , Date date) {
        return  "客户端："+channel.remoteAddress()+text+"["+sdf.format(date)+"]";
    }
}