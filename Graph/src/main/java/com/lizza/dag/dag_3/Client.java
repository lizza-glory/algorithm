package com.lizza.dag.dag_3;

import java.util.Stack;

/**
 * 1. 要解决的问题: 资源重复加载
 * 2. 方式: 资源从上往下进行加载 todo
 * 5   6    7
 *  \ / \ / |
 *   3   4  |
 *    \ / \ |
 *     1    2
 */
public class Client {

    public static void main(String[] args){
    	apply(new Node_1());
    }

    public static void apply(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node e = stack.pop();
            System.out.println(e.name() + ": " + e.children);
            if (e.parents.size() > 0) {
                for (Node parent : e.parents) {
                    parent.children.add(e);
                    stack.push(parent);
                }
            }
        }
    }
}
