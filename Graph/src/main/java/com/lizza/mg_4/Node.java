package com.lizza.mg_4;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Sets;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.Set;
import java.util.Stack;
import java.util.concurrent.Executors;
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
public abstract class Node {

    static Node node_3 = new Node_3();
    static Node node_4 = new Node_4();
    static Node node_5 = new Node_5();
    static Node node_6 = new Node_6();
    static Node node_7 = new Node_7();

    volatile boolean isCompleted = false;

    Set<Node> parents = Sets.newHashSet();

    Set<Node> children = Sets.newHashSet();
    
    static Stopwatch stopwatch = Stopwatch.createStarted();

    static ListeningExecutorService executorService
            = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

    abstract void compute(Request request, Context context);

    abstract int value();

    Node currentNode() {
        return this;
    }

    public MutableGraph<Node> parseGraph() {
        MutableGraph<Node> graph = GraphBuilder.directed().allowsSelfLoops(false).build();
        Stack<Node> stack = new Stack<>();
        stack.push(this);
        while (!stack.isEmpty()) {
            Node e = stack.pop();
            if (e.parents.size() > 0) {
                for (Node parent : e.parents) {
                    parent.children.add(e);
                    stack.push(parent);
                    // parent -> e
                    graph.putEdge(parent, e);
                }
            }
        }
        return graph;
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
            return value * request.getCount() + sum;
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
            isCompleted = true;
        }
    }

    boolean checkComplete(MutableGraph<Node> graph) {
        Set<Node> predecessors = graph.predecessors(currentNode());
        for (Node predecessor : predecessors) {
            if (!predecessor.isCompleted) {
                return false;
            }
        }
        return !isCompleted;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public static void main(String[] args){
        Node node = new Node_1();
        MutableGraph<Node> graph = node.parseGraph();
        Context context = new Context();
        Request request = new Request(10);
        context.setGraph(graph);
//        HashMap<String, Node> nodeMap = graph.nodes().stream()
//                .filter(item -> graph.inDegree(item) == 0)
//                .collect(Collectors.toMap(e -> e.getClass().getSimpleName(), v -> v,
//                        (k, v) -> v, Maps::newHashMap));
//        for (Node root : nodeMap.values()) {
//            root.compute(request, context);
//        }
        graph.nodes().stream()
                .filter(item -> graph.inDegree(item) == 0)
                .forEach(root -> {
                    root.compute(request, context);
                });
    }
}
