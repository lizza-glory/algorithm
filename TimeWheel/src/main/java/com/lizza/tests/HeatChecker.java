package com.lizza.tests;

import java.util.Random;

/**
 * 心跳检测器
 */
public class HeatChecker {

    private final static Random RANDOM = new Random();
    public static boolean getHeatBeat(String url, long timeout) {
        // 模拟网络延时情况
        long time = new Integer(RANDOM.nextInt(1500)).longValue();
        System.out.printf("check heat beat, url: %s, time: %d%n", url, time);
        return time <= timeout;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            getHeatBeat("https://www.baidu.com", 1000);
        }
    }
}
