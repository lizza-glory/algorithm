package com.lizza.BitOpt;

import org.junit.Test;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 思路: 将数组中所有元素加和, 与 1 ~ n 的和相减, 结果便为缺失的数字
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    @Test
    public void test1() {
        int[] nums = new int[]{0,1,2,3,4,5,6,7,9};
        System.out.println(missingNumber(nums));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{0};
        System.out.println(missingNumber(nums));
    }

    @Test
    public void test3() {
        int[] nums = new int[]{0, 1};
        System.out.println(missingNumber(nums));
    }
}
