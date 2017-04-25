package com.nchu.tech.mq.service;

import com.nchu.tech.mq.module.Person;
import com.nchu.tech.mq.sender.CopyDemoSender;
import com.nchu.tech.mq.sender.DemoSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Rabbit Mq 小样测试
 * Created by fujianjian on 2017/4/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRabbitMqTest {

    @Autowired
    private DemoSender demoSender;

    @Autowired
    private CopyDemoSender demoSenderBackup;

    @Test
    public void testDemoSender() throws Exception {
        demoSender.sender();
    }

    @Test
    public void testOneSenderToManyReceiver() throws Exception {
        for (int i = 0; i < 100; i++) {
             this.demoSender.sender(i);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @Test
    public void testManySenderToManyReceiver() throws Exception {

        for (int i = 0; i < 100; i++) {
            this.demoSender.sender(i);
            this.demoSenderBackup.sender(i);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @Test
    public void testObjectSender() throws Exception {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setId(String.valueOf(System.currentTimeMillis()));
            person.setAge(10);
            person.setGender("M");
            person.setName(String.format("James %d", i));
            this.demoSender.senderObject(person);

            TimeUnit.SECONDS.sleep(1);

        }

    }
}
