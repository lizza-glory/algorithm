package com.lizza.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CommonTests {

    @Test
    public void test1() throws Exception {
        Map<String, Integer> map = new HashMap<>(13);
        map.put("a", 1);
        System.out.println(map);
    }

    @Test
    public void test2() throws Exception {
        Map<String, Integer> map = new ConcurrentHashMap<>(13);
        map.put("a", 1);
        System.out.println(map);
    }

    // 获取指定数字的最接近的 2 的幂次方的数字; 比如给定 13 返回 16
    @Test
    public void test3() throws Exception {
        System.out.println(getMaxNum(13));
        System.out.println(getMaxNum(25));
        System.out.println(getMaxNum(1));
    }

    // 给定一个固定长度的数组, 给定一个时间, 计算在数组中的索引
    @Test
    public void test4() throws Exception {
        int length = 15;
        System.out.println(5 & length);
        System.out.println(10 & length);
        System.out.println(17 & length);
    }

    public int getMaxNum(int num) {
        int result = 1;
        while (result <= num) {
            result <<= 1;
        }
        return result;
    }
}
