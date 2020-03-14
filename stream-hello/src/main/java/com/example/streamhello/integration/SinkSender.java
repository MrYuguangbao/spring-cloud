package com.example.streamhello.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author admin
 * @date 2020/3/10 16:08
 */

public class SinkSender {/*@EnableBinding(value = {SinkSender.SinkOutput.class})
@Configuration(value = "integrationSender")*/
    private static Logger logger = LoggerFactory.getLogger(SinkSender.class);

    public static final String MESSAGE_TOPIC = "input";

    /**
     * 将输出通道绑定到input的主题中
     */
    public interface SinkOutput {
        @Output(MESSAGE_TOPIC)
        MessageChannel output();
    }

    /**
     * 用于生产消息，将当前时间返回
     *
     * @return
     * @InboundChannelAdapter 用于SinkOutput.OUTPUT通道的输出绑定，以2秒的频率轮询执行
     */
    @Bean
    @InboundChannelAdapter(value = MESSAGE_TOPIC, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<String> timerMessageSource() {
        logger.info("spring integration的消息生产开始");
        return () -> new GenericMessage<>("{\"name\":\"喻光宝\",\"age\":18}");
    }


}
