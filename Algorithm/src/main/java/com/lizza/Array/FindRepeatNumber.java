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
 * 题目说: 在一个长度为 n 的数组 nums 里的所有数字都在 0 ~ n-1 的范围内, 即数组中的数字不会
 * 超过数组长度
 * 遍历数组, 对比数组中数字与数组下标的关系
 * 相同: 下一个
 * 不相同: 尝试交换
 *      被交换的位置有值, 且和当前位置的数字相同: 说明重复了, return
 *      被交换的位置和当前位置不同, 直接交换
 * 注意: 指针移动的条件: 是下标和对应位置的数相同
 */
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (i == nums[i]) {
                i++;
                continue;
            }
            // 被交换的位置的数字(nums[nums[i]])和当前位置的数字(nums[i])相同, 说明重复
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[nums[i]];
            nums[tmp] = tmp;
        }
        return -1;
    }

    @Test
    public void test1() {
        System.out.println(findRepeatNumber(new int[]{3, 4, 2, 0, 0, 1}));
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
