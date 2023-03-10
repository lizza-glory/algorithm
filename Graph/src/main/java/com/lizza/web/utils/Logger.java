package com.lizza.web.utils;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义的日志类
 */
public class Logger {

    private static final Pattern PATTERN = Pattern.compile("\\{\\}");

    public static void info(String pattern, Object... args) {
        Matcher matcher = PATTERN.matcher(pattern);
        int index = 0;
        while (matcher.find()) {
            pattern = pattern.replaceFirst("\\{\\}", "{" + index++ + "}");
        }
        String message = MessageFormat.format(pattern, args);
        System.out.println(message);
    }
}
