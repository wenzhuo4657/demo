package code.rocketmq.java.base;


import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @className: Consumer
 * @author: wenzhuo4657
 * @date: 2024/5/3 16:31
 * @Version: 1.0
 * @description: 消费者示例
 */
public class Consumer {
    public static void main(String[] args) throws MQClientException {

        DefaultMQPushConsumer consumer =new DefaultMQPushConsumer("my-consumer-group1");
        consumer.setNamesrvAddr("192.168.213.131:9876");
        consumer.subscribe("MyTopic1","*");//消费主题和过滤主题的条件，此处*表示不做过滤
        consumer.registerMessageListener(
                new MessageListenerConcurrently() {
                    @Override
                    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                        for (MessageExt msg : msgs){
                            System.out.println("收到的消息："+new String(msg.getBody()));
                        }
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;//成功消耗
                    }
                }
        );
        consumer.start();
        System.out.println("消费者启动");
    }
}