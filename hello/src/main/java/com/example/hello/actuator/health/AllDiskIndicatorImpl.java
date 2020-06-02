package com.example.hello.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author admin
 * @date 2020/2/10 12:35
 */
@Component("allDisk0")
public class AllDiskIndicatorImpl implements HealthIndicator {


    @Override
    public Health health() {
        File[] files = File.listRoots();
        if (files != null && files.length != 0) {
            long total = 0, free = 0;
            for (File file : files) {
                total += file.getTotalSpace();
                free += file.getUsableSpace();
            }
            long used = total - free;
            double useRate = total == 0 ? 0 : ((double) used / total);
            return Health.up().withDetail("total", total).withDetail("free", free).withDetail("usage", useRate * 100).build();
        } else {
            return Health.down().build();
        }
    }
}
