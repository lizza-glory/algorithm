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
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        int i = 0, j = postorder.length -1, m = 0;
        while (postorder[m] < postorder[j]) {
            m++;
        }
        System.out.println(m);
        return false;
    }

    public void verify(int[] array, int i, int j, int m) {
        while (array[m] < array[j]) {
            m++;
        }
    }

    @Test
    public void test1() {
        int[] array = new int[]{1,3,2,6,5};
        verifyPostorder(array);
    }
}
