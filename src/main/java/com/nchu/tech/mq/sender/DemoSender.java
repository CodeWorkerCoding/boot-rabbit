package com.nchu.tech.mq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 发送者的小样
 * Created by fujianjian on 2017/4/25.
 */
@Component
public class DemoSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sender() {
        String content = String.format("Hello this is sender demo at %s", LocalDateTime.now());
        System.out.println(String.format("Sender: %s", content));
        this.rabbitTemplate.convertAndSend("Demo", content);
    }
    public void sender(Integer sequence) {
        String content = String.format("Hello this is sender demo at %s", LocalDateTime.now());
        System.out.println(String.format("Sender %d th:==============>>>> %s", sequence, content));
        this.rabbitTemplate.convertAndSend("Demo", content);
    }
}
