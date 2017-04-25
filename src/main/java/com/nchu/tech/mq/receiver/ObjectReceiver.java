//package com.nchu.tech.mq.receiver;
//
//import com.nchu.tech.mq.module.Person;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * 对象的接收者
// * Created by fujianjian on 2017/4/25.
// */
//@Component
//@RabbitListener(queues = "Object")
//@Slf4j
//public class ObjectReceiver {
//
//    @RabbitHandler
//    public void receiverObject(Person person) {
//        log.info(String.format("Object Receiver: ===============> %s", person.toString()));
//    }
//}
