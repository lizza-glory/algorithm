package com.lizza.dag_5;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-07
 */
public class Context {

    private Map<String, Integer> map = Maps.newConcurrentMap();

    public void setValue(String key, Integer value) {
        map.put(key, value);
    }

    public Integer getValue(String key) {
        return map.get(key);
    }
}
