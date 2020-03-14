package com.example.ribbonconsumer.controller;

import com.example.ribbonconsumer.service.HelloService;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 * @date 2020/2/6 18:13
 */
@RestController
public class ConsumerController {

    private static Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    /*-------------------------- 1 ---------------------------*/
    /*@Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        logger.info("---------------开始调用ribbon-consumer接口--------------");
        String body = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        return body;
    }*/

    /*-------------------------- 2 ---------------------------*/
    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.helloService();
    }

}
