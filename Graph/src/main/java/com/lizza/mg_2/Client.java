package com.lizza.mg_2;

import com.google.common.base.Stopwatch;
import com.google.common.graph.MutableGraph;
import com.lizza.Request;

import java.util.concurrent.TimeUnit;

/**
 * 1. 要解决的问题: 资源重复加载
 * 2. 方式: 资源从上往下进行加载
 * 5   6    7
 *  \ / \ / |
 *   3   4  |
 *    \ / \ |
 *     1    2
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Node node = new Node_1();
        Request request = new Request(10);
        MutableGraph<Node> graph = node.parseGraph();
        Context context = new Context();
        context.setGraph(graph);
        for (Node e : graph.nodes()) {
            // 入度为 0 为根节点
            if (graph.inDegree(e) == 0) {
                e.apply(context, request);
            }
        }
        System.out.println(context.getNodeMap().get("Node_1") + ", cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
