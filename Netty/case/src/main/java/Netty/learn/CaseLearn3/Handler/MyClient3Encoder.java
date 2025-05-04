package Netty.learn.CaseLearn3.Handler;

import Netty.learn.CaseLearn3.MessageProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.List;

/**
 * @className: MyClient3Encoder
 * @author: wenzhuo4657
 * @date: 2024/4/25 10:45
 * @Version: 1.0
 * @description:  自定义编码器
 */
public class MyClient3Encoder extends MessageToByteEncoder<MessageProtocol> {

    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {
        out.writeInt(msg.getLength());//阅读源码可知此处占用4字节
        out.writeBytes(msg.getContent());
    }
}