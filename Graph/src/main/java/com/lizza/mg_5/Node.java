package com.lizza.mg_5;

import com.google.common.base.Stopwatch;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 1. 要解决的问题: 资源重复加载
 * 2. 方式: 资源从上往下进行加载
 * 5   6    7
 *  \ / \ / |
 *   3   4  |
 *    \ / \ |
 *     1    2
 */
public abstract class Node {

    /** 当前节点是否完成 **/
    AtomicBoolean isCompleted = new AtomicBoolean(false);
    
    static Stopwatch stopwatch = Stopwatch.createStarted();

    static ListeningExecutorService executorService
            = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

    /**
     * 节点计算方法
     * @param request 请求
     * @param context 上下文对象, 存入计算过程中节点的值
     */
    abstract void compute(Request request, Context context);

    abstract int value();

    Node currentNode() {
        return this;
    }

    public void printGraph(MutableGraph<Node> graph) {
        for (Node e : graph.nodes()) {
            System.out.println(e + ": predecessors: "
                    + graph.predecessors(e) + ", successors: "
                    + graph.successors(e) + ", inDegree: "
                    + graph.inDegree(e) + ", outDegree: "
                    + graph.outDegree(e));
        }
    }

    int handle(MutableGraph<Node> graph, Request request, Context context) {
        try {
            Thread.sleep(value() * 100);
            int value = request.getCount() * value();
            int sum = graph.predecessors(currentNode())
                    .stream().map(node -> node.getClass().getSimpleName())
                    .mapToInt(context::getValue)
                    .sum();
            return value + sum;
        } catch (Exception e) {
            System.out.println("error: " + currentNode().getClass().getSimpleName());
            e.printStackTrace();
        }
        return 0;
    }

    void handleSuccessors(MutableGraph<Node> graph, Request request, Context context, Integer value) {
        try {
            Set<Node> nodes = graph.successors(currentNode());
            context.setValue(currentNode().getClass().getSimpleName(), value);
            for (Node node : nodes) {
                node.compute(request, context);
            }
            System.out.println(currentNode().getClass().getSimpleName() + ": " + value + ", cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        } finally {
            isCompleted.compareAndSet(false, true);
        }
    }

    /**
     * 检查父节点是否执行完成
     * @param graph
     * @return boolean
     */
    boolean checkComplete(MutableGraph<Node> graph) {
        Set<Node> predecessors = graph.predecessors(currentNode());
        for (Node predecessor : predecessors) {
            if (!predecessor.isCompleted.get()) {
                return false;
            }
        }
        return !isCompleted.get();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public static void main(String[] args){
        MutableGraph<Node> graph = GraphBuilder.directed().allowsSelfLoops(false).build();
        Node node_1 = new Node_1();
        Node node_2 = new Node_2();
        Node node_3 = new Node_3();
        Node node_4 = new Node_4();
        Node node_5 = new Node_5();
        Node node_6 = new Node_6();
        Node node_7 = new Node_7();
        graph.putEdge(node_5, node_3);
        graph.putEdge(node_6, node_3);
        graph.putEdge(node_6, node_4);
        graph.putEdge(node_7, node_4);
        graph.putEdge(node_7, node_2);
        graph.putEdge(node_3, node_1);
        graph.putEdge(node_4, node_1);
        graph.putEdge(node_4, node_2);

        node_1.printGraph(graph);

        Context context = new Context();
        Request request = new Request(100);
        context.setGraph(graph);

        graph.nodes().stream()
                .filter(item -> graph.inDegree(item) == 0)
                .forEach(root -> {
                    root.compute(request, context);
                });
    }
}
