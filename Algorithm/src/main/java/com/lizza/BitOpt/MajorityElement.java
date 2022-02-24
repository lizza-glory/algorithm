package com.lizza.BitOpt;

import org.junit.Test;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 *
 * 解法: 摩尔投票法
 * 1. 计票器 vote, 遇到相同的数字票数加 1
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int result = 0, vote = 0;
        for (int num : nums) {
            // 如果计票器归 0, 众数置为当前数
            if (vote == 0) {
                result = num;
            }
            // 每次循环判断当前数是否是众数, 如果是众数, 计数器 +1, 否则 -1
            vote += (num == result ? 1 : -1);
        }
        return result;
    }

    @Test
    public void test1() {
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(nums));
    }
}
