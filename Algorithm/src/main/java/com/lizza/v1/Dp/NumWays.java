package com.lizza.v1.Dp;

import org.junit.Test;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶
 * 总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 *
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 *
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 *
 * 设跳上 n 级台阶有 f(n) 种跳法。在所有跳法中，青蛙的最后一步只有两种情况：
 * 跳上 1 级或 2 级台阶。
 * 当为 1 级台阶： 剩 n-1 个台阶，此情况共有 f(n-1) 种跳法；
 * 当为 2 级台阶： 剩 n-2 个台阶，此情况共有 f(n-2) 种跳法。
 * f(n) 为以上两种情况之和，即 f(n)=f(n-1)+f(n-2)，以上递推性质为斐波那契数列。
 * 本题可转化为 求斐波那契数列第 n 项的值 ，与面试题10- I. 斐波那契数列 等价，
 * 唯一的不同在于起始数字不同:
 *  青蛙跳台阶问题： f(0)=1, f(1)=1, f(2)=2；
 *  斐波那契数列问题： f(0)=0, f(1)=1, f(2)=1。
 */
public class NumWays {

    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    @Test
    public void test1() {
        System.out.println(numWays(2));
        System.out.println(numWays(7));
    }
}
