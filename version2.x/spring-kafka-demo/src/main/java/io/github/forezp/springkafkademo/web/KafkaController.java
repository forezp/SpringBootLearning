package io.github.forezp.springkafkademo.web;

import io.github.forezp.springkafkademo.entity.User;
import io.github.forezp.springkafkademo.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

@RestController
public class KafkaController {


    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("/test")
    public User createMsg() {
        User user = new User();
        user.setAge(new Random().nextInt(20));
        user.setId(new Random().nextInt(20));
        user.setName(UUID.randomUUID().toString());
        kafkaProducer.sendUserMessage(user);
        return user;
    }
}