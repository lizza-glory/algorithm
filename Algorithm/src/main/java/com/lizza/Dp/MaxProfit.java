package com.lizza.Dp;

import com.lizza.util.Logger;
import org.junit.Test;

/**
 * 剑指 Offer 63. 股票的最大利润
 *
 * 思路:
 * 1. 设 cost 为最低买入价格, profit 为最大利润, 初始都为 0
 * 2. 遍历数组, cost = min(prices[i], cost), profit = max(prices[i] - cost, profit)
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(price, cost);
            profit = Math.max(price - cost, profit);
            Logger.info("cost: {}, profit: {}", cost, profit);
        }
        return profit;
    }

    @Test
    public void test1() throws Exception {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
