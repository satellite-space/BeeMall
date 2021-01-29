package com.bee.mall.demo.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

/**
 * description: 消费者 <br>
 * date: 2021/1/28 21:50 <br>
 * author: Administrator
 * version: 1.0 <br>
 */
@Component
public class Consumer {

    public void consumer() {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("PushConsumer");
        consumer.setNamesrvAddr("192.168.1.101:9876");
        try{
            // 订阅PushTopic下Tag为push的消息
            consumer.subscribe("PushTopic", "push");

            // 程序第一次启动从消息队列头取数据
            consumer.setConsumeFromWhere(
                    ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET
            );
            consumer.registerMessageListener(
                    (MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {
                        Message msg = list.get(0);
                        String topic = msg.getTopic();
                        System.out.println("topic = " + topic);
                        byte[] body = msg.getBody();
                        System.out.println("body:  " + new String(body));
                        String keys = msg.getKeys();
                        System.out.println("keys = " + keys);
                        String tags = msg.getTags();
                        System.out.println("tags = " + tags);
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    }
            );
            consumer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
