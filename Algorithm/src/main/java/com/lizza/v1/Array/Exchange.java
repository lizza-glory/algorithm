package com.lizza.v1.Array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4] 
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 思路:
 *  1. 类似快速排序, 首尾指针, 找到奇数往前放, 找到偶数往后放
 */
public class Exchange {

    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            // 从左向右寻找偶数
            while (nums[i] % 2 != 0 && i < j){
                i++;
            }
            // 从右向左寻找奇数
            while (nums[j] % 2 == 0 && i < j){
                j--;
            }

            // 找到后交换
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return nums;
    }

    @Test
    public void test1() {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(exchange(nums)));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{1,3,5};
        System.out.println(Arrays.toString(exchange(nums)));
    }

    @Test
    public void test3() throws Exception {
        System.out.println(2 % 2);
        System.out.println(3 % 2);
    }
}
