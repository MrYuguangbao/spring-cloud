package com.example.springcloudstreamapp1.app1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.annotation.rxjava.RxJavaProcessor;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @author admin
 * @date 2020/3/10 20:43
 */
//@EnableBinding(value = {Processor.class})
public class App1 {

    private static Logger logger = LoggerFactory.getLogger(App1.class);

    /* 方法一：@StreamListener(Processor.INPUT) @SendTo(Processor.OUTPUT)*/
    /* 方法二：通过Spring Integration的原生注解*/
    @ServiceActivator(outputChannel = Processor.OUTPUT, inputChannel = Processor.INPUT)
    public Object receiveFromInput(Object payload) {
        logger.info("App1 Received:" + payload);
        return "From input channel Return - " + payload;
    }


}
