package com.example.trace2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class Trace2Application {
    public static final Logger logger = LoggerFactory.getLogger(Trace2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Trace2Application.class, args);
    }

    @GetMapping(value = "/trace-2")
    public String trace(HttpServletRequest request) {
        logger.info("---------调用trace-2接口-------,TraceID={},SpanId={},ParentSpanId={},Sampled={},SpanName={}",
                request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId"),
                request.getHeader("X-B3-ParentSpanId"), request.getHeader("X-B3-Sampled"),
                request.getHeader("X-Span-Name"));
        return "Trace2接口返回结果";
    }


}
