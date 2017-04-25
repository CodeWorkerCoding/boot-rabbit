package com.nchu.tech.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Rabbit Mq 配置
 * Created by fujianjian on 2017/4/24.
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue primitiveQueue() {
        return new Queue("Demo");
    }

    @Bean
    public Queue objectQueue() {
        return new Queue("Object");
    }
}
