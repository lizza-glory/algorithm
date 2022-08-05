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
}
