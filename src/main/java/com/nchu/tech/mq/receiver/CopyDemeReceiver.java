package com.nchu.tech.mq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 复制一个接收者小样
 * Created by fujianjian on 2017/4/25.
 */

@Component
@RabbitListener(queues = "Demo")
public class CopyDemeReceiver {

    @RabbitHandler
    public void processBackup(String content) {
        System.out.println(String.format("Receiver 2 th:--------> %s", content));
    }
}
