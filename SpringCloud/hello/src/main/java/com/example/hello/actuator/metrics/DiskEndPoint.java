package com.example.hello.actuator.metrics;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author admin
 * @date 2020/2/10 12:51
 */
@Configuration
@Endpoint(id = "diskspaceinfo")
public class DiskEndPoint {

    @ReadOperation
    public Map<String, Object> diskInfo() {
        Map<String, Object> map = new ConcurrentHashMap<>();
        File[] files = File.listRoots();
        if (files != null && files.length != 0) {
            long total = 0, free = 0;
            for (File file : files) {
                total += file.getTotalSpace();
                free += file.getFreeSpace();
            }
            long used = total - free;
            double useRate = (double) used / total * 100;
            map.put("diskTotal", total);
            map.put("diskFree", free);
            map.put("diskUseRate", useRate);
        }

        return map;
    }

}
