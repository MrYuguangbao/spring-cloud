package com.example.streamhello.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

/**
 * 将Input消息通道作为输出通道的接口
 *
 * @author admin
 * @date 2020/3/10 15:26
 */
public interface SinkSender {
    @Output(Sink.INPUT)
    MessageChannel output();
}
