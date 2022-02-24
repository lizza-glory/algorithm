package com.lizza.mg_1;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;

/**
 * 5   6    7
 *  \ / \ / |
 *   3   4  |
 *    \ / \ |
 *     1    2
 */
public class MutableGraph_1 {

    public static void main(String[] args){
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
}
