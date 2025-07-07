package com.lizza.v1.Tree;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，
 * 那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 * 思路:
 * 1. 如果左右孩子节点都为 null, 说明该节点是对称的
 * 2. 如果只有一个孩子节点为 null, 或者 val 不同说明不对称
 * 3. 递归判断左右孩子节点
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return root == null || recursive(root.left, root.right);
    }

    boolean recursive(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return recursive(left.left, right.right) && recursive(left.right, right.left);
    }
}
