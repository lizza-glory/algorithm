package com.lizza.Tree;

import org.junit.Test;

import java.util.Arrays;

/**
 * 剑指 Offer 07. 重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 示例 1:
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 思路
 * 构建树, 需要构建出当前节点的 value, 左子树 left, 右子树 right
 * 整个构建借助递归去实现
 *
 * 先序遍历数组的第一个元素是根节点; 该节点对应到中序遍历中, 左边是左子树, 右边是右子树
 *
 * 如何得到左/右子树的先序遍历?
 * 左/右子树的先序遍历存在于 preorder 中, 用数组 copy 的方式的到, 前提是知道开始和结束的下标
 *
 * 如何得到左/右子树的中序遍历?
 * 左/右子树的先序遍历存在于 inorder 中, 用数组 copy 的方式的到, 前提是知道开始和结束的下标
 *
 * 如何得到左/右子树先/中序遍历的下标?
 * 左子树先序:
 * 右子树先序:
 * 左子树中序:
 * 右子树中序:
 *
 * index 如何计算?
 * index 指根节点在中序数组中的下标, 遍历中序数组, 其值等于根节点时, 返回下标
 *
 * 递归终止条件?
 * 数组长度为 0
 *
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        // 1. 构建根节点
        TreeNode root = new TreeNode(preorder[0]);

        // 获取根节点的中序遍历数组的下标
        int index = getIndex(root, inorder);

        // 2. 构建左子树: root.left = buildTree(左子树的先序遍历数组, 左子树的中序遍历数组)
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1),
                              Arrays.copyOfRange(inorder, 0, index));

        // 3. 构建右子树: root.right = buildTree(右子树的先序遍历, 右子树的中序遍历)
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return root;
    }

    public int getIndex(TreeNode root, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                return i;
            }
        }
        return 0;
    }

    @Test
    public void test0() throws Exception {
        int[] array = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(Arrays.copyOfRange(array, 0, 2)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(array, 1, 2)));
    }
}
