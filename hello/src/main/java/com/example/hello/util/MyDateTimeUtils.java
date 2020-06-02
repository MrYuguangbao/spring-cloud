package com.example.hello.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author admin
 * @date 2020/3/1 16:49
 */
public class MyDateTimeUtils {

    public static String format(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd E HH:mm:ss");
        String result = formatter.format(dateTime);
        return result;
    }


}
