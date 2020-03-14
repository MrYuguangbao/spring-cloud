package com.example.zipkinserverfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.internal.EnableZipkinServer;*/

//@EnableZipkinServer  默认采用HTTP方式启动ZipkinServer
//@EnableZipkinStreamServer // 采用Stream通信方式启动ZipkinServer，也支持HTTP方式
@SpringBootApplication
public class ZipkinServerFinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerFinalApplication.class, args);
    }

}
