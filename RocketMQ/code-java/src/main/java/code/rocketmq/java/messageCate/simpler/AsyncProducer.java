package code.rocketmq.java.messageCate.simpler;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
  /**
     *  des:异步发送
   *  使用回调函数处理消息反馈
     * */
public class AsyncProducer {
  public static void main(String[] args) throws Exception {
    // Initialize a producer and set the Producer group name
    DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
    // Set the address of NameServer
    producer.setNamesrvAddr("localhost:9876");
    // Start Producer
    producer.start();
    producer.setRetryTimesWhenSendAsyncFailed(0);//消息发送失败重试0次
    int messageCount = 100;
    final CountDownLatch countDownLatch = new CountDownLatch(messageCount);//反馈计数
    for (int i = 0; i < messageCount; i++) {
      try {
          final int index = i;
          // Create a message and set the topic, tag, body and so on. The tag can be understood as a label to categorize the message, and RocketMQ can filter the tag on the consumer side.
          Message msg = new Message("TopicTest",
            "TagA",
            "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
            // Send a message asynchronously, the result is returned to the client by callback
          producer.send(msg, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
              System.out.printf("%-10d OK %s %n", index,
                sendResult.getMsgId());
              countDownLatch.countDown();
            }
            @Override
            public void onException(Throwable e) {
              System.out.printf("%-10d Exception %s %n", index, e);
              e.printStackTrace();
              countDownLatch.countDown();
            }
          });
        } catch (Exception e) {
            e.printStackTrace();
            countDownLatch.countDown();
        }
    }
    //If reliable transmission is required for asynchronous sending, the logic must not be terminated until a clear result is returned from the callback interface. Otherwise, closing the Producer immediately may result in some messages not being successfully transmitted.
    countDownLatch.await(5, TimeUnit.SECONDS);//阻塞方法，
      /**
         *  des:离开阻塞的条件
       *  1，超过所设置的最长等待时间，此处为5分钟
       *  2，计数达到0
         * */
    // Close the producer once it is no longer in use
    producer.shutdown();
  }
}