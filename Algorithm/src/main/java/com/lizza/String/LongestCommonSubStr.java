package com.lizza.String;

import org.junit.Test;

/**
 * 最长公共子串
 *
 * 参考: https://blog.51cto.com/JavaAlliance/5268123
 *
 * 思路:
 * 1. 动态规划解决(其他解法: 滑动窗口)
 * 2. s1 s2 作为二维数组, dp[i][j] 表示是否相同, 相同为 1 加上前一格的值(dp[i-1][j-1]), 不同为 0
 */
public class LongestCommonSubStr {

    public int longestCommonSubStr(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int[][] dp = new int[arr2.length][arr1.length];

        // 第一行
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[0]) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
        }

        // 第一列
        for (int i = 0; i < arr2.length; i++) {
            if (arr1[0] == arr2[i]) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }

        // dp[i][j]
        for (int i = 1; i < arr2.length; i++) {
            for (int j = 1; j < arr1.length; j++) {
                if (i < arr1.length && j < arr2.length && arr1[j] == arr2[i]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int max = dp[0][0];
        for (int[] arr : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                max = Math.max(max, arr[j]);
            }
        }
        return max;
    }

    @Test
    public void test1() throws Exception {
        System.out.println(longestCommonSubStr("abc", "caba"));
        System.out.println(longestCommonSubStr("1AB2345CD", "12345EF"));
    }
}
