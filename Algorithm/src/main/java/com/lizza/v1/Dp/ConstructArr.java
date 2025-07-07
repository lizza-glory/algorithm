package com.lizza.v1.Dp;

import org.junit.Test;

/**
 * 剑指 Offer 66. 构建乘积数组
 *
 * 思路:
 * 1. 创建同样大小的数组 b
 * 2. 从左往右遍历数组, 第 i 处的元素为 i 左边所有元素的乘积: b[i] = b[i - 1] * b[i - 2] * ... * b[0]
 * 3. 从右往左遍历数组, 第 i 处的元素为 i 右边所有元素的乘积乘于它本身: b[i] = b[i] * b[i + 1] * b[i + 2] * ... * b[b.length - 1]
 * 4.
 */
public class ConstructArr {

    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        // 从左往右遍历数组, 第 i 处的元素为 i 左边所有元素的乘积
        for (int i = 0, result = 1; i < a.length; result *= a[i++]) {
            b[i] = result;
        }
        // 从右往左遍历数组, 第 i 处的元素为 i 右边所有元素的乘积乘于它本身
        for (int i = a.length - 1, result = 1; i >= 0; result *= a[i--]) {
            b[i] *= result;
        }
        return b;
    }

    @Test
    public void test1() throws Exception {
        int[] a = new int[]{1,2,3,4,5};
        constructArr(a);
    }
}
