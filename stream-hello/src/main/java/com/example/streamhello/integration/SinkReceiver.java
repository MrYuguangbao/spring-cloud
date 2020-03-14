package com.example.streamhello.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author admin
 * @date 2020/3/10 16:08
 */
/*@EnableBinding(value = {Sink.class})
@Configuration(value = "integrationReceiver")*/
public class SinkReceiver {
    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @ServiceActivator(inputChannel = SinkSender.MESSAGE_TOPIC)
    public void receive(Object payload) {
        logger.info("[spring integration] ----> Received ----> : " + payload);
    }

    @Transformer(inputChannel = SinkSender.MESSAGE_TOPIC, outputChannel = SinkSender.MESSAGE_TOPIC)
    public Object transForm(String message) {
        ObjectMapper mapper = new ObjectMapper();
        IntegrationUser result = null;
        try {
            result = mapper.readValue(message, IntegrationUser.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
