package code.rocketmq.java.messageCate.Broadcast;


import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @className: Consumer
 * @author: wenzhuo4657
 * @date: 2024/5/3 16:31
 * @Version: 1.0
 * @description:
 * 消息的消费模式
 * 聚类：应用聚类模式时，每条消息都需要由消费者组中的一个消费者处理。
 * 广播：在应用广播模式时，RocketMQ 将每条消息广播给消费者组内的所有消费者，确保每个消费者至少消费一次该消息。*
 *
 */
public class Consumer {
    public static void main(String[] args) throws MQClientException {

        DefaultMQPushConsumer consumer =new DefaultMQPushConsumer("my-consumer-group1");
        consumer.setNamesrvAddr("192.168.213.131:9876");
        consumer.setMessageModel(MessageModel.BROADCASTING);//设置消息模式
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