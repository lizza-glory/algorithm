package com.lizza.mg_4;

import com.google.common.collect.Maps;
import com.google.common.graph.MutableGraph;

import java.util.Map;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-07
 */
public class Context {

    private Map<String, Integer> map = Maps.newConcurrentMap();

    private MutableGraph<Node> graph;

    public void setValue(String key, Integer value) {
        map.put(key, value);
    }

    public Integer getValue(String key) {
        return map.get(key);
    }

    public MutableGraph<Node> getGraph() {
        return graph;
    }

    public void setGraph(MutableGraph<Node> graph) {
        this.graph = graph;
    }
}
