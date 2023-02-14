package com.lizza.Stack;

import org.junit.Test;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，
 * 否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 *
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 *
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * 思路:
 * 二叉搜索树后续遍历的特点
 * 1. 最后一个元素是根节点
 * 2. 左子树的所有值均小于根节点
 * 3. 右子树的所有值均大于根节点
 *
 * 解题套路
 * 1. 利用指针遍历数组
 * 2. 如果元素比根节点小, 指针右移
 * 3. 如果元素比根节点大, 说明找到了右子树的起点, 记录位置, 继续遍历; 如果右子树中出现小于根节点的元素, 返回 false
 * 4. 递归遍历左右子树
 *
 * 分界点如何处理
 * 分界点利用局部变量进行记录
 *
 * 如何判断左右子树和根节点的关系
 * 定义一个新函数去处理, 且支持递归处理
 *
 * 子函数逻辑和作用
 * 1. 利用指针遍历整个数组, 找到分界点 mid
 * 2. 递归遍历左右子树
 *
 * 指针的初始值?
 * i 表示起始下标, j 表示结束下标, 指针最开始需要指向起始下标
 *
 * 子函数中后序遍历数组
 *
 * 子函数终止条件
 * i 和 j 重合
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null) {
            return false;
        }
        return verify(0, postorder.length - 1, postorder);
    }


    public boolean verify(int i, int j, int[] postorder) {
        if (i >= j) {
            return true;
        }

        int index = i;
        while (postorder[index] < postorder[j]) {
            index++;
        }

        int p = index;
        while (postorder[index] > postorder[j]) {
            index++;
        }
        return index == j && verify(i, p - 1, postorder) && verify(p, j - 1, postorder);
    }


    @Test
    public void test1() {
        int[] array = new int[]{1,3,2,6,5};
        System.out.println(verifyPostorder(array));
    }
}
