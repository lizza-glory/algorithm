package com.lizza.v1.Array;

import org.junit.Test;

/**
 * 统计一个数字在排序数组中出现的次数。nums 是一个非递减数组
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 思路:
 * 1. 二分查找确定边界
 * 2. 问题点: 如何确定左右边界?
 */
public class Search {

    public int search(int[] nums, int target) {
        return binSearch(nums, target) - binSearch(nums, target - 1);
    }

    public int binSearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            // 说明要找的数在右半区
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    @Test
    public void test1() throws Exception {
        int[] arr = new int[]{5,7,7,8,8,10};
        System.out.println(binSearch(arr, 8));
    }
}
