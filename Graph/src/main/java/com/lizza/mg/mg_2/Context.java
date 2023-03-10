package com.lizza.mg.mg_2;

import com.google.common.collect.Maps;
import com.google.common.graph.MutableGraph;
import lombok.Data;

import java.util.Map;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
@Data
public class Context {

    private MutableGraph<Node> graph;
    private Map<String, Integer> nodeMap = Maps.newConcurrentMap();
}
