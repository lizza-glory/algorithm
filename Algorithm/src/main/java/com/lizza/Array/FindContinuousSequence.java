package com.lizza.Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 思路:
 * 1. 滑动窗口
 *      - 窗口左边界: i, 右边界: j
 *      - 计算窗口内的和 s, 并和目标 t 比较
 *          s > t i 向右移动, 缩小窗口
 *          s < t j 向右移动, 扩大窗口
 * 2. 终止条件?
 *      i < j
 *
 */
public class FindContinuousSequence {

    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, s = 3;
        List<int[]> result = new ArrayList<>();
        while (i < j) {
            if (s == target) {
                int[] arr = new int[j - i + 1];
                for (int m = i; m <= j; m++) {
                    arr[m - i] = m;
                }
                result.add(arr);
            }
            if (s > target) {
                s -= i++;
            } else {
                s += ++j;
            }
        }
        return result.toArray(new int[0][]);
    }

    @Test
    public void test1() {
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{1, 2});
        result.add(new int[]{3, 4, 5});
        System.out.println(Arrays.deepToString(result.toArray(new int[0][])));
    }

    @Test
    public void test2() throws Exception {
        System.out.println(Arrays.deepToString(findContinuousSequence(9)));
    }
}
