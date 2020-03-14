package com.example.hello.actuator.metrics;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.io.File;

/**
 * @author admin
 * @date 2020/2/10 12:42
 */
@Component("customDiskMetrics")
public class DiskMetrics implements MeterBinder {

    private File rootFilePath;

    public DiskMetrics() {
        rootFilePath = new File(".");
    }


    @Override
    public void bindTo(@NotNull MeterRegistry meterRegistry) {
        Gauge.builder("diskInfo.total", rootFilePath, File::getTotalSpace).register(meterRegistry);
        Gauge.builder("diskInfo.free", rootFilePath, File::getFreeSpace).register(meterRegistry);
        Gauge.builder("diskInfo.useRate", rootFilePath, c -> {
                    long totalDiskSpace = rootFilePath.getTotalSpace();
                    if (totalDiskSpace == 0) {
                        return 0.0;
                    }
                    long used = totalDiskSpace - rootFilePath.getFreeSpace();
                    return (double) used / totalDiskSpace * 100;
                }
        ).register(meterRegistry);


    }
}
