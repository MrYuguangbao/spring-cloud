package com.example.feignconsumer.controller;

import com.example.feignconsumer.feign.HelloService;
import com.example.feignconsumer.model.User;
import com.example.feignconsumer.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @date 2020/2/7 20:12
 */
@RestController
public class FeignConsumerController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private RefactorHelloService refactorService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }

    @GetMapping(value = "/feign-consumer2")
    public String helloConsumer2() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(helloService.hello()).append("\n")
                .append(helloService.hello("DIDI")).append("\n")
                .append(helloService.hello("DIDI", 30)).append("\n")
                .append(helloService.hello(new User("DIDI", 30))).append("\n");
        return buffer.toString();
    }

    @GetMapping(value = "/feign-consumer3")
    public String helloConsumer3() {
        StringBuilder builder = new StringBuilder();
        builder.append(refactorService.hello("MIMI")).append("\n");
        builder.append(refactorService.hello("MIMI", 20)).append("\n");
        builder.append(refactorService.hello(new com.ygb.dto.User("MIMI", 20))).append("\n");
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "abc,jlk,ljl";
        String[] strings = StringUtils.commaDelimitedListToStringArray(s);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
