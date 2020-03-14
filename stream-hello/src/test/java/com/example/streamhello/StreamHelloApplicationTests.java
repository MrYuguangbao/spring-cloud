package com.example.streamhello;

import com.example.streamhello.integration.IntegrationTest;
import com.example.streamhello.integration.SinkSender;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;

import java.util.Date;

@SpringBootTest
class StreamHelloApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(StreamHelloApplicationTests.class);

    /**
     * 注入绑定接口
     */
    @Autowired
    private SinkSender sinkSender;

    /**
     * 注入消息通道
     */
    @Autowired
    private MessageChannel input;

    @Test
    void contextLoads() {
        //sinkSender.output().send(org.springframework.messaging.support.MessageBuilder.withPayload("From SinkSender注入绑定接口测试").build());
        //input.send(org.springframework.messaging.support.MessageBuilder.withPayload("From SinkSender注入消息通道测试").build());
        input.send(org.springframework.messaging.support.MessageBuilder.withPayload("From SinkSender注入消息通道（当存在多实例时）测试").build());
    }
}
