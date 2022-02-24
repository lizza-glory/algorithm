package com.lizza.Stack;

import org.junit.Test;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * 思路:
 * 1. 搜索二叉树中序遍历是一个递增序列
 * 2. 前节点 preNode 如果为空, 说明当前节点 curNode 是头节点 head
 * 3. 前节点 preNode 不为空, curNode 的 left 指向 preNode,
 * preNode 的 right 指向 curNode
 */
public class BinTreeToLinkedList {

    private Node preNode;
    private Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        traverse(root);
        preNode.right = head;
        head.left = preNode;
        return head;
    }

    public void traverse(Node curNode) {
        if (curNode == null) {
            return;
        }
        traverse(curNode.left);
        if (preNode == null) {
            head = curNode;
        } else {
            preNode.right = curNode;
            curNode.left = preNode;
        }
        preNode = curNode;
        traverse(curNode.right);
    }

    @Test
    public void test1() {
        Node _1 = new Node(1);
        Node _2 = new Node(2);
        Node _3 = new Node(3);
        Node _4 = new Node(4);
        Node _5 = new Node(5);
        _2.left = _1;
        _2.right = _3;
        _4.left = _2;
        _4.right = _5;
        Node nodeR = treeToDoublyList(_4);
        while (nodeR.right != null || nodeR.right != head) {
            System.out.println(nodeR);
            nodeR = nodeR.right;
        }
//        Node nodeL = treeToDoublyList(_4);
//        while (nodeL.left != null && nodeR.left != head) {
//            System.out.println(nodeL);
//            nodeL = nodeL.left;
//        }
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }
}
