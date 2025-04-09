package code.rocketmq.java.messageCate.simpler;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

  /**
     *  des: 同步发送
   *  阻塞等待消息反馈
     * */
public class SyncProducer {
  public static void main(String[] args) throws Exception {
    // Initialize a producer and set the Producer group name
    DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name"); //（1）
    // Set the address of NameServer
    producer.setNamesrvAddr("localhost:9876");  //（2）
    // Start Producer
    producer.start();
    for (int i = 0; i < 100; i++) {
      // Create a message and set the topic, tag, body and so on. The tag can be understood as a label to categorize the message, and RocketMQ can filter the tag on the consumer side.
      Message msg = new Message("TopicTest" /* Topic */,
        "TagA" /* Tag */,
        ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
        );   //（3）
      // Use the producer to send and wait for the result of sending synchronously
      SendResult sendResult = producer.send(msg);   //（4）
      System.out.printf("%s%n", sendResult);
    }
    // Close the producer once it is no longer in use
    producer.shutdown();
  }
}