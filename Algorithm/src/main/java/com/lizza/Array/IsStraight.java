package com.lizza.Array;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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
 * 思路:
 * 1. 除大小王之外, 不允许有重复, 使用 set 去重
 * 2. 最大减去最小不能超过 5
 * 3. 终止条件
 */
public class IsStraight {

    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 13, max = 1;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (set.contains(num)) {
                return false;
            }
            min = Math.min(num, min);
            max = Math.max(num, max);
            set.add(num);
        }
        return (max - min) <= 5;
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
}
