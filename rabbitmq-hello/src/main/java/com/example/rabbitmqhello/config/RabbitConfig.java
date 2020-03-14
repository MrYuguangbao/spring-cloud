package com.example.rabbitmqhello.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author admin
 * @date 2020/3/4 15:22
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

}
