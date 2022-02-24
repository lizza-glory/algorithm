package com.lizza.Array;

import org.junit.Test;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * [3, 4, 2, 0, 0, 1] > 0
 *
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 *
 * 思路: 原地交换
 */
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            // 如果当前数和下标相同, [重点]指针向前移动
            if (nums[i] == i) {
                i++;
                continue;
            }
            // 当前数如果和下标不相同, 但是当前数作为下标的位置的数, 与当前数相同, 说明重复
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            // 当前数和下标不相同, 且没有重复, 则进行交换, 交换过程中, 下标不动
            // 交换完成后,
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    @Test
    public void test1() {
        int[] nums = new int[]{3, 4, 2, 0, 0, 1};
        System.out.println(findRepeatNumber(nums));
    }
}
