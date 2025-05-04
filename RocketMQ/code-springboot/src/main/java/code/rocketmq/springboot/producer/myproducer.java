package code.rocketmq.springboot.producer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @className: myproducer
 * @author: wenzhuo4657
 * @date: 2024/5/4 17:22
 * @Version: 1.0
 * @description:
 */

@Component
public class myproducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    public static void main(String[] args) {

    }
}