package com.lizza.Array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，
 * 则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 思路:
 * 注意: 真实面试题会要求考虑 int 越界问题
 * 1. 先根据 n 求出 n 位数的最大值
 * 2. 然后遍历写入数组
 */
public class PrintNumbers {

    public int[] printNumbers(int n) {
        int max = (int) (Math.pow(10, n) - 1);
        int[] result = new int[max];
        for (int i = 0; i < max; i++) {
            result[i] = i + 1 ;
        }
        return result;
    }

    @Test
    public void test1() {
        System.out.println(Arrays.toString(printNumbers(3)));
    }
}
