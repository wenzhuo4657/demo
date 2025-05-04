package code.rocketmq.java.base;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;


/**
 * @className: Producer
 * @author: wenzhuo4657
 * @date: 2024/5/3 16:12
 * @Version: 1.0
 * @description: 生产者示例
 */
public class Producer {
    public static void main(String[] args) throws  Exception{
        DefaultMQProducer producer =new DefaultMQProducer("my-producer-group1");
        producer.setNamesrvAddr("192.168.213.131:9876");
          /**
             *  des: 注意，
           生产者发送消息时，会先在本地查询 Topic 路由信息。
           如果查询不到，会请求 NameServer 查询。
           也就是说查到发送topic属于的集群下所有bloker信息，
             * */
        producer.start();
        for(int i=0;i<10;i++){
            Message message=new Message("MyTopic1","TagA",("hello rocketmq"+i).getBytes(StandardCharsets.UTF_8));
            System.out.println(producer.send(message));
        }
        producer.shutdown();


    }


}