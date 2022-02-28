package com.lizza.Tree;

import org.junit.Test;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *  
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 * 思路:
 *  1. 计算左右子树的高度, 绝对值不超过 1
 *  2. 递归计算左右子树是否平衡
 */
public class IsBalanced {

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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        // 终止条件: 当前节点为 null, 即越过叶子节点
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }


    @Test
    public void test1() {
        TreeNode treeNode = TreeNode.getTree();
        System.out.println(depth(treeNode));
    }
}
