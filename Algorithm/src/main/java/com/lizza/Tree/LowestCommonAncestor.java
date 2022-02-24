package com.lizza.Tree;

import org.junit.Test;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
 * （一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *       3
 *    /    \
 *   5      1
 *  / \    / \
 * 6   2  0   8
 *    / \
 *   7   4
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为
 * 节点本身。
 *
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 *
 * 题型一: 一般二叉树
 * 题型二: 搜索二叉树; 对于搜索二叉树, 可以根据其特性, 判断 p 和 q 的值与 root 的值
 * 的关系
 *        从而只需要遍历左子树或右子树
 * 思路:
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 难点: 终止条件
        if (root == null || p == root || q == root) {
            return root;
        }
        // 递归查找左右节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 左节点为空, 返回右节点
        if (left == null) {
            return right;
        }
        // 右节点为空, 返回左节点
        if (right == null) {
            return left;
        }
        return root;
    }

    /**
     * 最近公共祖先
     *          6
     *       /    \
     *      4      8
     *     / \    / \
     *    2   5  7   9
     *   /
     *  1
     */
    @Test
    public void test1() {

    }
}
