package com.lizza.v2.pointer;

import org.junit.Test;

/**
 * 题目描述: https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 解题: https://leetcode.cn/problems/container-with-most-water/solutions/207215/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, result = 0;
        while (true) {
            if (left >= right) {
                return result;
            }
            // 面积
            int area = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(result, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
    }

    @Test
    public void test1() throws Exception {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
