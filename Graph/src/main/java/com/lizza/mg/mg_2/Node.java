package com.lizza.mg.mg_2;

import com.google.common.collect.Sets;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.lizza.mg.Request;
import com.lizza.mg.Result;

import java.util.Set;
import java.util.Stack;
import java.util.concurrent.Executors;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public abstract class Node {

    volatile boolean finished = false;

    static final ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(3));

    Set<Node> parents = Sets.newHashSet();

    Set<Node> children = Sets.newHashSet();

    abstract Result apply(Context context, Request request) throws Exception;

    abstract String name();

    @Override
    public String toString() {
        return name();
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
                    + graph.successors(e) + ", degree: "
                    + graph.inDegree(e));
        }
    }
}
