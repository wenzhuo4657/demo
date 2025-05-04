package code.rocketmq.java.messageCate.ord;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.List;
  /**
     *  des: 顺序消息示例
     * */
public class Producer {
    public static void main(String[] args) throws UnsupportedEncodingException {
        try {
            DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
//             producer.setNamesrvAddr("localhost:9876");该变量的配置在启动项中配置了环境变量自动获取
            producer.start();

            String[] tags = new String[] {"TagA", "TagB", "TagC", "TagD", "TagE"};
            for (int i = 0; i < 100; i++) {
                int orderId = i % tags.length;
                Message msg =
                    new Message("TopicTest", tags[i % tags.length], "KEY" + i,
                        ("orderId:"+orderId+"\ttag:"+tags[orderId]).getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {

                      /**
                         *  des:
                       *  mqs：查询到的broker的队列集合
                       *  msg：将要传输的消息
                       *  arg：orderId，此处需要理解的是，该函数是由mq框架去调用，会将orderId做为参数，
                       *  retrun ：该消息将要传输给的队列
                       *
                       *
                       *  注意：此处并没有保证不同队列之间的有序，但保证了队列内部的有序
                       *
                         * */
                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
//                        Integer id = (Integer) arg;
//                        int index = id % mqs.size();
                        return mqs.get(0);
                    }
                }, orderId);

                System.out.printf("%s%n", sendResult);
            }

            producer.shutdown();
        } catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}