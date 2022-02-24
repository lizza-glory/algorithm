package com.lizza.Array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 */
public class FindContinuousSequence {

    public int[][] findContinuousSequence(int target) {
//        // 滑动窗口左右指针
//        int i = 1, j = 2;
//        // 数组
//        List<int[]> result = new ArrayList<>();
//        while (i < j && j < target) {
//            int sum = i + j;
//            if (sum == target) {
//                for (int k = i; k <= j; k++) {
//
//                }
//                result.add()
//            }
//        }
        return new int[1][];
    }

    @Test
    public void test1() {
        int[][] result = new int[3][];
        result[0] = new int[]{1,2,3};
        result[1] = new int[]{4,5};
        result[2] = new int[]{7,8,9,10};
        System.out.println(Arrays.deepToString(result));
    }
}
