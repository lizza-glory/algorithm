package com.lizza.Dp;

import org.junit.Test;

/**
 * 剑指 Offer 47. 礼物的最大价值
 *
 * 思路: 动态规划
 * 利用二维数组 dp 保存历史记录, 避免重复计算
 * 1. dp[i][j] 表示当前位置的礼物价值
 * 2. dp[i][j] = Max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]; 即: i, j 处的最大值等于
 *    取前一行的最大值或者前一列的最大值, 加上当前元素
 * 3. dp[0][0] = grid[0][0]
 */
public class GiftMaxValue {

    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        // i 和 j 需要从第 1 行第一列开始, 所以需要先计算出第 1 行第 1 列的 dp
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void test1() throws Exception {
        int[][] grid = new int[][]{{1,2,5},{3,2,1}};
        System.out.println(maxValue(grid));
    }

    @Test
    public void test2() throws Exception {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(maxValue(grid));
    }
}
