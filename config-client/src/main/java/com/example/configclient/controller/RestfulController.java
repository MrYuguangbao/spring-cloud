package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @date 2020/3/5 16:23
 */
@RefreshScope
@RestController
public class RestfulController {

    @Value("${from}")
    private String from;

    @Autowired
    private Environment env;

    @RequestMapping("/from/value")
    public String fromByValue() {
        return "通过@Value注解获取的from值:" + from;
    }

    @RequestMapping("/from/env")
    public String fromByEnvironment() {
        return "通过Environment获取的from值:" + env.getProperty("from", "undefined");
    }

}
