package com.lizza.Tree;

/**
 * 题目: 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 链接: https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * 思路: 据二叉树镜像的定义，考虑递归遍历（dfs）二叉树，交换每个节点的左 / 右子节点，
 * 即可生成二叉树的镜像。
 */
public class MirrorTree {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        root.left = _2;
        root.right = _3;
        TreeNode _4 = new TreeNode(4);
        TreeNode _5 = new TreeNode(5);
        TreeNode _6 = new TreeNode(6);
        TreeNode _7 = new TreeNode(7);
        _2.left = _4;
        _2.right = _5;
        _3.left = _6;
        _3.right = _7;
        mirrorTree(root);

    }

    /**
     *      1
     *    /   \
     *   2     3
     *  / \   / \
     * 4   5 6   7
     */
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(left);
        return root;
    }
}
