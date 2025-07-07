package com.lizza.v1.Tree;

import org.junit.Test;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 链接: https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/?favorite=xb9nqhhg
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * 思路:
 * 1. 搜索二叉树中序遍历是一个递增序列
 * 2. 前节点 preNode 如果为空, 说明当前节点 curNode 是头节点 head
 * 3. 前节点 preNode 不为空, curNode 的 left 指向 preNode,
 * preNode 的 right 指向 curNode
 *
 * 双向链表如何形成?
 * 前驱节点: pre.right = cur, 当前节点: cur.left = pre
 *
 * 头尾如何连接?
 * head.left = tail, tail.right = head
 *
 * 头结点和尾结点如何确立?
 * 头结点: 前驱节点 pre 为空时, 说明是链表的头结点
 * 尾结点: 中序遍历完成后, pre 指向的是链表的尾结点
 */
public class BinTreeToLinkedList {

    private Node head;
    private Node pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        recursive(root);

        // 收尾相连
        head.left = pre;
        pre.right = head;

        return head;
    }

    public void recursive(Node cur) {
        if (cur == null) {
            return;
        }
        recursive(cur.left);
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
            cur.left = pre;
        }
        // pre 后移
        pre = cur;
        recursive(cur.right);
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
