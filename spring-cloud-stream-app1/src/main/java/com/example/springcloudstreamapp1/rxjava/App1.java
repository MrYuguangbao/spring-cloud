package com.example.springcloudstreamapp1.rxjava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.rxjava.EnableRxJavaProcessor;
import org.springframework.cloud.stream.annotation.rxjava.RxJavaProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
 * @date 2020/3/11 8:51
 */
@EnableRxJavaProcessor
@Configuration(value = "rxjavaApp1")
public class App1 {

    private static Logger logger = LoggerFactory.getLogger(com.example.springcloudstreamapp1.app1.App1.class);

    @Bean
    public RxJavaProcessor<String, String> processor() {
        return inputStream -> inputStream.map(
                data -> {
                    logger.info("RxJava Received:" + data);
                    return data;
                }
        ).map(data -> String.valueOf("RxJava From Input Channel Return - " + data));
    }

}
