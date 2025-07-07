package com.lizza.v1.BitOpt;

import org.junit.Test;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为
 * '1' 的个数（也被称为汉明重量）。
 *
 * 示例 1：
 *
 * 输入：n = 11 (控制台输入 00000000000000000000000000001011)
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
 *
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 思路
 * 1. 将给定数无符号右移, 和 1 做与运算
 */
public class HammingWeight {

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result += n & 1;
            n >>>= 1;
        }
        return result;
    }

    @Test
    public void test1() {
        System.out.println(hammingWeight(11));
    }
}
