package com.lizza.mg_reactor_1;

import com.google.common.collect.Maps;
import com.google.common.graph.MutableGraph;
import lombok.ToString;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-07
 */
@ToString
public class Context {

    private AtomicInteger value = new AtomicInteger();

    private MutableGraph<Node> graph;

    public void setValue(Integer value) {
        this.value.set(value);
    }

    public Integer getValue() {
        return value.get();
    }

    public MutableGraph<Node> getGraph() {
        return graph;
    }

    public void setGraph(MutableGraph<Node> graph) {
        this.graph = graph;
    }
}
