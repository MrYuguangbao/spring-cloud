package com.example.feignconsumer.feign;

import com.example.feignconsumer.model.User;
import com.example.feignconsumer.service.impl.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author admin
 * @date 2020/2/7 20:06
 */
@FeignClient(name = "hello-service", fallback = HelloServiceFallback.class)
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @GetMapping(value = "/hello1")
    String hello(@RequestParam("name") String name);

    @GetMapping(value = "/hello2")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @GetMapping(value = "/hello3")
    String hello(@RequestBody User user);
}
