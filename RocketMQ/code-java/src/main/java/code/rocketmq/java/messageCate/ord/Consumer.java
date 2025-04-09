package code.rocketmq.java.messageCate.ord;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @className: Consumer
 * @author: wenzhuo4657
 * @date: 2024/5/4 14:34
 * @Version: 1.0
 * @description: 顺序消费者示例，主要在于监听器的不同
 *
 * 注意：由于生产者仅仅保证了队列有序，没有保证不同队列之间的有序，此处的监听器也仅仅是接收生产者推送到消费者的消息
 * 所以，消费者也仅仅能保证队列内部消息的消费有序，如果消费了多条队列上的消息，并没有保证他们之间的有序
 */
public class Consumer {
    public static void main(String[] args) throws  Exception{
        DefaultMQPushConsumer consumer=new DefaultMQPushConsumer("please_rename_unique_group_name");
        consumer.subscribe("TopicTest","*");

        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                context.setAutoCommit(true);
                for (MessageExt msg:msgs){
                    System.out.println("消息内容："+new String(msg.getBody()));
                }
                return  ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumer.start();
        System.out.println("消费者启动");


    }
}