package com.example.springcloudstreamapp2.app2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;

/**
 * @author admin
 * @date 2020/3/10 21:54
 */
@EnableBinding(value = {Processor.class})
public class App2 {
    private static Logger logger = LoggerFactory.getLogger(App2.class);

    @Bean
    @InboundChannelAdapter(value = Processor.OUTPUT, poller = @Poller(fixedDelay = "3000"))
    public MessageSource<String> timerMessageSource() {
        return () -> new GenericMessage<>("自定义payload");
    }

    @StreamListener(Processor.INPUT)
    public void receiveFromOutput(Object payload) {
        logger.info("App2 Received: " + payload);
    }

}
