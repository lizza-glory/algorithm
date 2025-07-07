package com.lizza.v1.Array;

import org.junit.Test;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 *
 * 输入：n = 11
 * 输出：0
 *
 * 限制：
 * 0 <= n < 2^31
 *
 * 思路:
 *
 */
public class FindNthDigit {

    public int findNthDigit(int n) {
        //
        for (int i = 0; i < n; i++) {
            int scale = 10;

            while (i%scale >= 0) {
                System.out.println(i);
                scale *= 10;
            }
        }
        return 1;
    }

    @Test
    public void test1() {
//        findNthDigit(19);
        System.out.println(19 / 100);
    }
}
