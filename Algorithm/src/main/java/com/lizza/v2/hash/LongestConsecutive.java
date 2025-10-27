package com.lizza.v2.hash;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 题目链接: https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 解题链接:
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int e : set) {
            // 寻找最小值, 起始值
            if (set.contains(e - 1)) {
                continue;
            }

            // 找到后, 开始找最大值
            int cursor = e + 1;
            while (set.contains(cursor)) {
                cursor++;
            }
            result = Math.max(result, cursor - e);
        }
        return result;
    }

    @Test
    public void test1() throws Exception {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
