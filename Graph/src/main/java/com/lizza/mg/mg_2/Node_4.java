package com.lizza.mg.mg_2;

import com.google.common.graph.MutableGraph;
import com.lizza.mg.Request;
import com.lizza.mg.Result;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
@EqualsAndHashCode(callSuper = false)
public class Node_4 extends Node {

    {
        parents.add(new Node_7());
        parents.add(new Node_6());
    }

    @Override
    Result apply(Context context, Request request) throws Exception {
        // 处理当前节点逻辑
        MutableGraph<Node> graph = context.getGraph();
        System.out.println(this.getClass().getSimpleName() + "do something...");
        Thread.sleep(400);
        context.getNodeMap().put(name(), request.getCount() * 4);
        Set<Node> successors = graph.successors(this);
        for (Node successor : successors) {
            successor.apply(context, request);
        }
        graph.removeNode(this);
        return null;
    }

    @Override
    String name() {
        return "Node_4";
    }
}
