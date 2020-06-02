package com.example.hello.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author admin
 * @date 2020/2/10 12:28
 */
@Component("allDisk2")
public class AllDiskSpaceHealthIndicator extends AbstractHealthIndicator {


    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        File[] files = File.listRoots();
        if (files != null && files.length != 0) {
            long total = 0, free = 0;
            for (File file : files) {
                total += file.getTotalSpace();
                free += file.getUsableSpace();
            }
            long used = total - free;
            double useRate = total == 0 ? 0 : ((double) used / total);
            builder.up().withDetail("total", total).withDetail("free", free).withDetail("usage", useRate * 100).build();
        } else {
            builder.down().build();
        }
    }
}
