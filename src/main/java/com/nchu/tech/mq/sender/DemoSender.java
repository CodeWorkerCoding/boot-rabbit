package com.nchu.tech.mq.sender;

import com.nchu.tech.mq.module.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 发送者的小样
 * Created by fujianjian on 2017/4/25.
 */
@Component
@Slf4j
public class DemoSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sender() {
        String content = String.format("Hello this is sender demo at %s", LocalDateTime.now());
        log.info(String.format("Sender: %s", content));
        this.rabbitTemplate.convertAndSend("Demo", content);
    }
    public void sender(Integer sequence) {
        String content = String.format("Hello this is sender demo at %s", LocalDateTime.now());
        log.info(String.format("Sender %d th:==============>>>> %s", sequence, content));
        this.rabbitTemplate.convertAndSend("Demo", content);
    }

    public void senderObject(Person person) {
        log.info(String.format("Object Sender: %s", person.toString()));
        this.rabbitTemplate.convertAndSend("Object", person);
    }
}
