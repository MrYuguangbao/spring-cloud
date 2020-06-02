package com.example.hello.controller;

import com.ygb.dto.User;
import com.ygb.service.HelloService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @date 2020/2/8 16:04
 */

@RestController
public class ReflectHelloController implements HelloService {


    @Override
    public String hello(@RequestParam("name") String name) {
        return "@RequestParam Hello " + name;
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        System.out.println("调用@RequestHeader Hello方法");
        return new User(name, age);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "@RequestBody Hello " + user.getName() + ", " + user.getAge();
    }

}
