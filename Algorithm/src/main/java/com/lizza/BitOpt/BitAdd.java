package com.lizza.BitOpt;

import org.junit.Test;

/**
 * 题目: 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/”
 * 四则运算符号。
 * 链接: https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * 定理1：设a，b为两个二进制数，则a+b = a^b + (a&b)<<1
 */
public class BitAdd {

    public int add(int x, int y) {
        // ^ 异或: 相同为 0 相异为 1, 计算结果
        // & 与  : 全 1 为 1 否则为 0, 计算是否需要进位

        return (x ^ y) + ((x & y) << 1);
    }

    @Test
    public void test1() {
        System.out.println(add(3, 9));
    }

    @Test
    public void test2() {
        System.out.println(add(111, 899));
    }
}
