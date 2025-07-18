package com.lizza.v1.Array;

import org.junit.Test;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，
 * 并按上述情形进行了一次旋转。请返回旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 思路:
 * 1. 二分查找法, 确定旋转点; 每次比较, 都是和右边界进行
 * 2. 如果中间数超过右边数, 则说明旋转点在右半部分
 * 3. 如果中间数小于右边数, 说明旋转点在左半部分
 * 4. 中间数与右边界相等, 右边界左移
 *
 * 什么时候算找到了呢?
 * i == j
 *
 * i 是左边界, j 是右边界
 */
public class MinArray {

    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (numbers[mid] > numbers[j]) {
                i = mid + 1;
            } else if (numbers[mid] < numbers[j]) {
                j = mid;
            } else {
                j--;
            }
        }
        System.out.println("i = " + i + ", j = " + j);
        return numbers[i];
    }

    @Test
    public void test1() {
        int[] numbers = new int[]{3,4,5,1,2};
        System.out.println(minArray(numbers));
    }

    @Test
    public void test2() {
        int[] numbers = new int[]{2,2,2,0,1};
        System.out.println(minArray(numbers));
    }

    @Test
    public void test3() {
        int[] numbers = new int[]{1,3,5};
        System.out.println(minArray(numbers));
    }

    @Test
    public void test4() {
        int[] numbers = new int[]{1};
        System.out.println(minArray(numbers));
    }

    @Test
    public void test5() {
        int[] numbers = new int[]{3,1};
        System.out.println(minArray(numbers));
    }

    @Test
    public void test6() {
        int[] numbers = new int[]{3,1,3};
        System.out.println(minArray(numbers));
    }

    @Test
    public void test7() {
        int[] numbers = new int[]{1,1};
        System.out.println(minArray(numbers));
    }
}
