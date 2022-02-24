package com.lizza.mg_2;

import com.google.common.graph.MutableGraph;
import com.lizza.Request;
import com.lizza.Result;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
@EqualsAndHashCode(callSuper = false)
public class Node_7 extends Node {

    @Override
    Result apply(Context context, Request request) throws Exception {
        MutableGraph<Node> graph = context.getGraph();
        // 处理当前节点逻辑
        System.out.println(this.getClass().getSimpleName() + "do something...");
        Thread.sleep(700);
        context.getNodeMap().put(name(), request.getCount() * 7);
        Set<Node> successors = graph.successors(this);
        for (Node successor : successors) {
            successor.apply(context, request);
        }
        graph.removeNode(this);
        return null;
    }

    @Override
    String name() {
        return "Node_7";
    }
}
