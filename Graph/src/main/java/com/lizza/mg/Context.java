package com.lizza.mg;

import com.google.common.collect.Maps;
import com.google.common.graph.MutableGraph;
import com.lizza.mg.mg_2.Node;

import java.util.Map;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public class Context {

    private MutableGraph<Node> graph;
    private Map<String, Integer> map = Maps.newConcurrentMap();

    public void setResult(String key, Integer value) {
        map.put(key, value);
    }
    public int getResult(String key) {
        return map.get(key);
    }
}
