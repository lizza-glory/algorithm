package com.lizza.mg.mg_1;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import com.lizza.web.utils.Logger;
import org.junit.Test;


public class MutableGraph_1 {

    /**
     * 5   6    7
     *  \ / \ / |
     *   3   4  |
     *    \ / \ |
     *     1    2
     */
    @Test
    public void test1() throws Exception {
        MutableGraph<Integer> graph = GraphBuilder.directed().allowsSelfLoops(false).build();
        graph.putEdge(5, 3);
        graph.putEdge(3, 1);
        graph.putEdge(6, 3);
        graph.putEdge(6, 4);
        graph.putEdge(4, 1);
        graph.putEdge(4, 2);
        graph.putEdge(7, 4);
        graph.putEdge(7, 2);
        for (Integer node : graph.nodes()) {
            System.out.println(node + ": " + graph.predecessors(node));
        }
    }

    /**
     * 单个节点获取父子节点集合
     */
    @Test
    public void test2() throws Exception {
        MutableGraph<Integer> graph = GraphBuilder.directed().allowsSelfLoops(false).build();
        graph.addNode(3);
        for (Integer node : graph.nodes()) {
            Logger.info("{} 的父节点是: {}", node, graph.predecessors(node));
            Logger.info("{} 的子节点是: {}", node, graph.successors(node));
        }
    }
}
