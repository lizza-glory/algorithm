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
 * 1. 初始定义计票器, 众数初始值为第一个元素, 遍历数组, 众数与数组中元素相同, 机票器+1, 否则-1
 * 2. 计票器为 0 时, 将众数更新为当前元素
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int vote = 0, result = 0;
        for (int num : nums) {
            if (vote == 0) {
                result = num;
            }
            vote += (result == num) ? 1 : -1;
        }
        return result;
    }

    @Test
    public void test1() {
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(nums));
    }
}
