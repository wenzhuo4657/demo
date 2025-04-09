package Netty.learn.CaseLearn3.Handler;

import Netty.learn.CaseLearn3.MessageProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.List;

/**
 * @className: MyServer3Decoder
 * @author: wenzhuo4657
 * @date: 2024/4/25 13:11
 * @Version: 1.0
 * @description: 解码器，注意该对象会保存在框架中进行复用，所以成员变量不设置为static也可以连续使用
 */
public class MyServer3Decoder extends ByteToMessageDecoder {
    int length=0;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("ByteBuf:"+in);
        if (in.readableBytes()>=4&&length==0){//保证可以读到完整4个字节，由于在编码时设置的是4个字节
            length=in.readInt();
        }

        if (in.readableBytes()<length ){
            System.out.println("读取中----");
            return;
        }
        byte[] content= new byte[length];
        in.readBytes(content);//注意这里将数据从通道中的buffer中取出到list中，这表明数据已经从客户端传输到服务端
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setContent(content);
        messageProtocol.setLength(length);
        out.add(messageProtocol);
        length=0;


    }
}