package Netty.learn.CaseLearn3;

/**
 * @className: MessageProtocol
 * @author: wenzhuo4657
 * @date: 2024/4/25 10:38
 * @Version: 1.0
 * @description: 自定义消息类
 */
public class MessageProtocol {

//    消息长度
    private  int length;

//    消息内容
    private  byte [] content;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}