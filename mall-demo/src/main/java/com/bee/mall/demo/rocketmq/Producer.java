package com.bee.mall.demo.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

/**
 * description: 生产者 <br>
 * date: 2021/1/28 21:23 <br>
 * author: Administrator
 * version: 1.0 <br>
 */
@Component
public class Producer {

    public void producer(String str) {
        DefaultMQProducer producer = new DefaultMQProducer("PushProducer");
        producer.setNamesrvAddr("192.168.1.101:9876");
        try {
            producer.start();

            Message msg = new Message("PushTopic", "push",
                    "1", str.getBytes());

            SendResult result = producer.send(msg);
            System.out.println("id: " + result.getMsgId()
                    + " result: {}" + result.getSendStatus());

            msg = new Message("PushTopic", "push",
                    "2", str.getBytes());
            result = producer.send(msg);
            System.out.println("id: " + result.getMsgId()
                    + " result: {}" + result.getSendStatus());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
    }

}
