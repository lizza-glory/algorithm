package com.lizza.Dp;

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
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            // 每次循环看前一位是否大于 0, 如果小于 0, 那么当前位置的值保持不变
            // 保持不变意味着最大和的连续数组计算中断, 重新开始
            nums[i] += Math.max(nums[i - 1], 0);
            result = Math.max(nums[i], result);
        }
        return result;
    }
}
