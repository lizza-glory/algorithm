package com.lizza.v1.Array;

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
 *
 * 滑动窗口去解
 * 窗口左边界: i, 右边界: j
 * 计算窗口内的和 s, 并和目标 t 比较
 *      s > t i 向右移动, 缩小窗口
 *      s < t j 向右移动, 扩大窗口
 *
 * 终止条件
 * i 和 j 相遇
 *
 * 边界如何初始化? 窗口内的和如何初始化?
 *  i 指向第一个元素
 *  j 指向第二个元素
 *  s 的初始值是 i + j
 *
 * 得到一组结果后, i 和 j 如何移动
 * 不移动
 *
 * 得到结果后, 如何加入到结果集
 * 遍历 i 到 j, 加入到结果集数组中, 数组下标计算方式: k - i
 * 结果集需要用 list 来保存
 *
 * i 和 j 移动过程中, 如何计算窗口内的值
 * i 往右移, s -= i++, 一定要先从 s 减掉, 再 i++
 * j 往右移, s += ++j, 一定要先 ++j 在加入到 s
 *
 * 死循环问题
 * s == target 之后, i 和 j 需要移动, 移动 j 来实现
 */
public class FindContinuousSequence {

    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, s = i + j;
        List<int[]> result = new ArrayList<>();
        while (i < j) {
            if (s == target) {
                int[] array = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    array[k - i] = k;
                }
                result.add(array);
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
