package com.lizza.v1.Dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * 链接: https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/?favorite=xb9nqhhg
 *
 * 视频讲解: https://www.bilibili.com/video/BV1Sf4y1z7DA/?spm_id_from=333.337.search-card.all.click&vd_source=b4974145db4a002a60536830f7890e47
 *
 * 思路:
 * 1. 利用归并排序解决
 * 2. 归并排序中, 记录逆序对的数量
 */
public class ReversePairs {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int left, int right) {
        // 终止条件, 左右边界相遇
        if (left >= right) {
            return 0;
        }
        // 计算中点
        int mid = left + right >> 1;
        // 分别计算左右两边的逆序对的数量, 相加得到总的数量; 左右边界如何确定: mid 为中点分开
        int result = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        // 归并排序结果数组, 最后是排好序的哦; 数组长度: 左右边界的长度
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, index = 0;
        // 归并排序循环条件:
        while (i <= mid && j <= right) {
            // 左边的数小于右边的数, 直接将左边的数加到 temp 数组
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                // 左边的数大于右边的数, 将右边的数加到 temp 数组, 并且逆序对数量进行增加: 增加的数量就是左边数组 i 之后所有元素的个数
                temp[index++] = nums[j++];
                result += mid - i + 1;
            }
        }
        // 将剩余的元素添加到 temp 数组
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= right) {
            temp[index++] = nums[j++];
        }

        // 把 temp copy 到原来数组中
        int k = left;
        for (int e : temp) {
            nums[k++] = e;
        }
        return result;
    }

    @Test
    public void test1() throws Exception {
        int[] array = new int[]{7,5,6,4};
        System.out.println(reversePairs(array));
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test2() throws Exception {
        int left = 1, right = 7;
        System.out.println(left + right >> 1);
        System.out.println((left + right) / 2);
    }
}
