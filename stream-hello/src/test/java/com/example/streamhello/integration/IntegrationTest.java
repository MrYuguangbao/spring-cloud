package com.example.streamhello.integration;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.core.MessageSource;

import java.util.Date;

/**
 * @author admin
 * @date 2020/3/10 16:56
 */
@SpringBootTest
public class IntegrationTest {
    private static Logger logger = LoggerFactory.getLogger(IntegrationTest.class);
    @Autowired
    private SinkSender integrationSender;

    @Test
    public void testSend() {
        /*logger.info("spring integration的消息生产开始");
        MessageSource<Date> dateMessageSource = integrationSender.timerMessageSource();
        logger.info("spring integration的消息生产完毕");*/
    }

}
