package com.example.streamhello.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * 接收rabbitmq的消费者
 *
 * @author admin
 * @date 2020/3/8 21:08
 */
@EnableBinding(value = {Sink.class, Source.class})
public class SinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receive(StreamUser payload) {
        logger.info("[Received]:" + payload);
    }

}
