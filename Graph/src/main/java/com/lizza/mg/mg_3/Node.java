package com.lizza.mg.mg_3;

import com.google.common.collect.Sets;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import com.lizza.mg.Context;

import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public abstract class Node {

    ExecutorService executorService = Executors.newFixedThreadPool(17);

    Set<Node> parents = Sets.newHashSet();

    Set<Node> children = Sets.newHashSet();

    abstract int compute(Context context, int request);

    abstract int weight();

    abstract void onSuccess(Context context, int request);

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
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

    void handle() {
        try {
            Thread.sleep(weight() * 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
