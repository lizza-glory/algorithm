package com.lizza.v1.Array;

import org.junit.Test;

/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
 * 可以看成任意数字。A 不能视为 14。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 *
 * 思路:
 * 随机抽 5 张牌, 可能重复, 那么成为顺子牌的首要条件是 最大和最小之差不超过 5
 * 大小王跳过
 *
 * 如何处理重复?
 * set 记录每张牌, 大小王除外, 如果出现重复, 说明不可能为顺子
 */
public class IsStraight {

    public boolean isStraight(int[] nums) {
        int min = 13, max = 1;
        int[] repeat = new int[13];
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (repeat[num - 1] != 0) {
                return false;
            }
            min = Math.min(min, num);
            max = Math.max(max, num);
            repeat[num - 1] = 1;
        }
        return (max - min) < 5;
    }

    @Test
    public void test1() {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(isStraight(nums));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{0,0,1,2,5};
        System.out.println(isStraight(nums));
    }

    @Test
    public void test3() {
        int[] nums = new int[]{1,6,5,4,2};
        System.out.println(isStraight(nums));
    }
}
