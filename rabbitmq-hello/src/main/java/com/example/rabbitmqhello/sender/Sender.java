package com.example.rabbitmqhello.sender;

import com.example.rabbitmqhello.utils.MyDateTimeUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author admin
 * @date 2020/3/4 15:14
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello rabbitmq:" + MyDateTimeUtil.format(LocalDateTime.now());
        System.out.println("Sender message:[" + context + "]");
        rabbitTemplate.convertAndSend("hello", context);
    }


}
