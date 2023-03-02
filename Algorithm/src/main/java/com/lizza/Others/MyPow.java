package com.lizza.Others;

import org.junit.Test;

/**
 * 剑指 Offer 16. 数值的整数次方
 *
 * 参考: https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solutions/112529/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
 *
 * 思路:
 * 1. 快速幂
 * 2. n 小于 0 时, 转换为 n >= 0 时的情况来解决
 */
public class MyPow {

    public double myPow(double x, int n) {
        double result = 1;

        // int 最小值边界考虑
        long m = n;

        // n 为负数, x 的 -n 次幂, 即为 1/x 的 n 次幂
        if (m < 0) {
            x = 1 / x;
            m = -m;
        }

        while (m > 0) {
            if ((m & 1) == 1) {
                result *= x;
            }
            x *= x;
            m >>= 1;
        }

        return result;
    }

    @Test
    public void test1() throws Exception {
        System.out.println(myPow(2.1d, 3));
    }

    @Test
    public void test2() throws Exception {
        System.out.println(Integer.toBinaryString(13));
        System.out.println(Integer.toBinaryString(13 >> 1));
        System.out.println(Integer.toBinaryString(13 >> 1 >> 1));
        System.out.println(Integer.toBinaryString(13 >> 1 >> 1 >> 1));

        System.out.println();
        System.out.println(Integer.toBinaryString(13 & 1));
        System.out.println(Integer.toBinaryString(13 >> 1 & 1));
        System.out.println(Integer.toBinaryString(13 >> 1 >> 1 & 1));
        System.out.println(Integer.toBinaryString(13 >> 1 >> 1 >> 1 & 1));
    }
}
