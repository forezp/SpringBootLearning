package io.github.forezp.springkafkademo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class kafkaConsumer {

    @KafkaListener(topics = {"test"}, groupId = "group-1")
    public void onMessage(ConsumerRecord<?, ?> record) {
        System.out.println("====消费者group-1开始消费消息===");
        System.out.println("topic:" + record.topic() + "|partition:" + record.partition() + "|offset:" + record.offset() + "|value:" + record.value());

    }

    @KafkaListener(topics = {"test"}, groupId = "group-2")
    public void onMessage2(ConsumerRecord<?, ?> record) throws InterruptedException {
        Thread.sleep(500);
        System.out.println("====消费者group-2开始消费消息===");
        System.out.println("topic:" + record.topic() + "|partition:" + record.partition() + "|offset:" + record.offset() + "|value:" + record.value());
    }
}
