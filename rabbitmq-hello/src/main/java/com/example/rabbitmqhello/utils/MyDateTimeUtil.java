package com.example.rabbitmqhello.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author admin
 * @date 2020/3/4 15:28
 */
public class MyDateTimeUtil {

    public static String format(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String dateTime = formatter.format(time);
        return dateTime;
    }

}
