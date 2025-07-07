package com.lizza.v1.Array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
 * 思路:
 * 1. 双指针法: 因为数组是递增数组, 使用首尾指针进行遍历
 * 2. 指针如何移动?
 *      sum > target 时, 右指针左移
 *      sum < target 时, 左指针右移
 *
 * 循环结束条件?
 * 左右指针相遇
 *
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > target) {
                j--;
            }
            if (sum < target) {
                i++;
            }
            if (sum == target) {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }

    @Test
    public void test1() {
        int[] nums = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{10,26,30,31,47,60};
        System.out.println(Arrays.toString(twoSum(nums, 40)));
    }
}
