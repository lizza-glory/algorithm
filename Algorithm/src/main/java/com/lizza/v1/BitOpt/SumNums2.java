package com.lizza.v1.BitOpt;

import org.junit.Test;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 * 思路:
 * 1. 使用递归, 但是不能使用 if 做终止条件
 * 2. 利用 && 的短路实现
 */
public class SumNums2 {


    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    @Test
    public void test1() throws Exception {
        System.out.println(sumNums(9));
    }
}
