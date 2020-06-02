package com.example.apigateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @date 2020/3/1 21:00
 */
@RestController
public class APIGatewayController {

    @RequestMapping("/local/hello")
    public String hello() {
        return "hello world local!";
    }


}
