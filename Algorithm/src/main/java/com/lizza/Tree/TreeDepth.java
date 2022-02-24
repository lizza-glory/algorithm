package com.lizza.Tree;

/**
 * 题目: 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点
 * （含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 例如：给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 深度为: 3
 * 链接: https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * 思路: 后序遍历, 取左右子树深度最大的那个, 然后 + 1
 */
public class TreeDepth {

    public static void main(String[] args){
        Node root = new Node(6);
        Node _3 = new Node(3);
        Node _7 = new Node(7);
        root.left = _3;
        root.right = _7;
        _3.left = new Node(1);
        _3.right = new Node(2);
        Node _4 = new Node(4);
        _7.left = _4;
        _7.right = new Node(8);
        _4.left = new Node(0);
        System.out.println(maxDepth(root));
    }
    
    public static int maxDepth(Node root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }
}
