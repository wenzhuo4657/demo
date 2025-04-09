package code.rocketmq.java.messageCate.simpler;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
  /**
     *  des: 单向发送
   *  不处理消息反馈
     * */
public class OnewayProducer {
  public static void main(String[] args) throws Exception{
    // Initialize a producer and set the Producer group name
    DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
    // Set the address of NameServer
    producer.setNamesrvAddr("localhost:9876");
    // Start Producer
    producer.start();
    for (int i = 0; i < 100; i++) {
      // Create a message and set the topic, tag, body and so on. The tag can be understood as a label to categorize the message, and RocketMQ can filter the tag on the consumer side.
      Message msg = new Message("TopicTest" /* Topic */,
        "TagA" /* Tag */,
        ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
      );
      // Since there is no request-answer processing when sending messages in the oneway method, if there is a message sending failure, data will be lost because there is no retry. If data cannot be lost, it is recommended to use the reliable synchronous or reliable asynchronous sending method.
      producer.sendOneway(msg);
    }
     // Close the producer once it is no longer in use
     producer.shutdown();
  }
}