package com.lizza.Dp;

import org.junit.Test;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 *
 * 动态规划
 * 参考: https://houbb.github.io/2020/01/23/data-struct-learn-07-base-dp
 *
 * 思路:
 * 1. 遍历数组
 *    a. 如果前一个元素的值大于 0, 则将当前元素与前一个元素的值相加, 相加后替换当前元素
 *    b. 如果前一个元素的值小于 0, 则当前元素不变
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            result = Math.max(nums[i], result);
        }
        return result;
    }

    @Test
    public void test1() {
        int[] nums = new int[]{-2,1};
        System.out.println(maxSubArray(nums));
    }
}
