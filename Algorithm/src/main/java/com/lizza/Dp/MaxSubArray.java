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
 * 1. 新建 max 变量, 取数组第一个值
 * 2. 从第二个元素开始遍历数组, 如果数组前一个元素大于 0, 则将当前元素和前一个元素求和, 放置到当前位置
 *    如果前一个元素小于 0, 当前位置元素不变
 * 3. 比较 max 和当前位置的元素, 取较大的赋值给 max
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            max = Math.max(nums[i], max);
        }
        return max;
    }

    @Test
    public void test1() {
        int[] nums = new int[]{-2,1};
        System.out.println(maxSubArray(nums));
    }
}
