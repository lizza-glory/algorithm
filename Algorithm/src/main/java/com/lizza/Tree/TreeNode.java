package com.lizza.Tree;

/**
 * 二叉树
 *          6
 *       /    \
 *      4      8
 *     / \    / \
 *    2   5  7   9
 *   /
 *  1
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
    public static TreeNode getTree() {
        TreeNode root = new TreeNode(6);
        TreeNode _4 = new TreeNode(4);
        TreeNode _8 = new TreeNode(8);
        root.left = _4;
        root.right = _8;
        TreeNode _2 = new TreeNode(2);
        _2.left = new TreeNode(1);
        _4.left = _2;
        _4.right = new TreeNode(5);
        _8.left = new TreeNode(7);
        _8.right = new TreeNode(9);
        
        return root;
    }
    @Override
    public String toString() {
        return val + "";
    }
}
