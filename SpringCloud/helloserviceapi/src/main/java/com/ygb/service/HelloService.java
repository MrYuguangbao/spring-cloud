package com.ygb.service;

import com.ygb.dto.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author admin
 * @date 2020/2/8 14:32
 */
@RequestMapping("/refactor")
public interface HelloService {

    @GetMapping(value = "/hello4")
    String hello(@RequestParam("name") String name);

    @GetMapping(value = "/hello5")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping(value = "/hello6")
    String hello(@RequestBody User user);

}
