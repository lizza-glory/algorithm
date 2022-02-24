package com.lizza.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class Tree {

    public Tree left;
    public Tree right;
    public Object value;

    public Tree(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    /**
     * 示例树: 123467
     *          1
     *       /    \
     *      2      3
     *     / \    /
     *    4   5  6
     *         \
     *          7
     * 先序遍历: 1245736
     * 中序遍历: 4257163
     * 后序遍历: 4752631
     * 层序遍历: 1234567
     */
    public static Tree initTree() {
        Tree root = new Tree(1);
        Tree _2 = new Tree(2);
        Tree _3 = new Tree(3);
        root.left = _2;
        root.right = _3;
        Tree _5 = new Tree(5);
        _2.left = new Tree(4);
        _2.right = _5;
        _3.left = new Tree(6);
        _5.right = new Tree(7);
        return root;
    }

    public static void preTraversal(Tree tree) {
        if (Objects.isNull(tree)) {
            return;
        }
        visit(tree);
        preTraversal(tree.left);
        preTraversal(tree.right);
    }

    public static void midTraversal(Tree tree) {
        if (Objects.isNull(tree)) {
            return;
        }
        midTraversal(tree.left);
        visit(tree);
        midTraversal(tree.right);
    }

    public static void tailTraversal(Tree tree) {
        if (Objects.isNull(tree)) {
            return;
        }
        tailTraversal(tree.left);
        tailTraversal(tree.right);
        visit(tree);
    }

    /**
     * 循环的方式遍历树: 中序遍历
     */
    public static void loopTraversal(Tree tree) {
        Stack<Tree> stack = new Stack<>();
        // 指针作用
        Tree current = tree;
        while (Objects.nonNull(current) || !stack.isEmpty()) {
            if (Objects.nonNull(current)) {
                stack.push(current);
                current = current.left;
            } else {
                Tree item = stack.pop();
                Tree.visit(item);
                current = item.right;
            }
        }
    }

    /**
     * 层序遍历
     * 1. 利用队列
     */
    public static void levelTraversal(Tree tree) {
        Queue<Tree> queue = new LinkedList<>();
        // 队首入队
        queue.add(tree);
        while (!queue.isEmpty()) {
            // 队尾出队
            Tree e = queue.poll();
            visit(e);
            if (e.left != null) {
                queue.add(e.left);
            }
            if (e.right != null) {
                queue.add(e.right);
            }
        }
    }

    public static void visit(Tree tree) {
        System.out.print(tree);
    }
}
