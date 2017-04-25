package com.nchu.tech.mq.receiver;

import com.nchu.tech.mq.module.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收者小样
 * Created by fujianjian on 2017/4/25.
 */
@Component
@RabbitListener(queues = "Demo")
@Slf4j
public class DemoReceiver {

    /****
     * 一个队列有多个有多个接收者， 但是接收者中只有一个接收方法
     */
    @RabbitHandler
    public void process(String content) {
        log.info(String.format("Receiver 1 th:--------> %s", content));
    }
}
