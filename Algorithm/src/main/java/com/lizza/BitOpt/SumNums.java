package com.lizza.BitOpt;

import org.junit.Test;

/**
 * 题目: 求 1+2+...+n ，要求不能使用
 * 乘除法、for、while、if、else、switch、case等关键字
 * 及条件判断语句（A?B:C）。
 * 链接: https://leetcode-cn.com/problems/qiu-12n-lcof/
 */
public class SumNums {

    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    @Test
    public void test1() {
        System.out.println(sumNums(9));
    }
}
