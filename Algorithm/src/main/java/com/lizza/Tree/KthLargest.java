package com.lizza.Tree;

import org.junit.Test;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 链接: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * 思路: 中序遍历 倒序
 */
public class KthLargest {

    int result, k;

    /**
     * 示例树: 01234678
     *          6
     *       /    \
     *      4      8
     *     / \    / \
     *    2   5  7   9
     *   /
     *  1
     * 先序遍历: 64215879
     * 中序遍历: 12456789
     * 后序遍历: 12547986
     */
    @Test
    public void test1() {
        Node root = new Node(6);
        Node _4 = new Node(4);
        Node _8 = new Node(8);
        root.left = _4;
        root.right = _8;
        Node _2 = new Node(2);
        _2.left = new Node(1);
        _4.left = _2;
        _4.right = new Node(5);
        _8.left = new Node(7);
        _8.right = new Node(9);
        System.out.println("\n" + kthLargest(root, 2));
    }

    public int kthLargest(Node root, int k) {
        this.k = k;
        traversal(root);
        return result;
    }

    /**
     * 中序遍历倒序
     */
    void traversal(Node root) {
        if (root == null) {
            return;
        }
        traversal(root.right);
        System.out.print(root.val);
        if (--k == 0) {
            result = root.val;
        }
        traversal(root.left);
    }
}
