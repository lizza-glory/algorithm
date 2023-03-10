package com.lizza.mg.mg_3;

import com.google.common.graph.MutableGraph;
import com.lizza.mg.Context;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    static ExecutorService executorService = Executors.newFixedThreadPool(17);

    public static void main(String[] args) {
        Node node = new Node_1();
        Context context = new Context();
        MutableGraph<Node> graph = node.parseGraph();
        for (Node item : graph.nodes()) {
            if (graph.inDegree(item) == 0) {
                CompletableFuture.supplyAsync(() -> {
                    return item.compute(context, 10);
                }, executorService);
            }
        }
        System.out.println(context.getResult(node.getClass().getSimpleName()));
        executorService.shutdown();
    }
}
