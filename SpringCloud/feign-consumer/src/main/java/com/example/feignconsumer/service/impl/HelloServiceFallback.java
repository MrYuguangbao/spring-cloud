package com.example.feignconsumer.service.impl;

import com.example.feignconsumer.feign.HelloService;
import com.example.feignconsumer.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author admin
 * @date 2020/2/8 16:57
 */
@Component
public class HelloServiceFallback implements HelloService {

    @Override
    public String hello() {
        return "hello 无参接口 error!";
    }

    @Override
    public String hello(@RequestParam("name") String name) {
        return "@RequestParam error!";
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User("@RequestHeader error!", 0);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "@RequestBody error!";
    }
}
