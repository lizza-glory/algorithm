package com.lizza.v1.Sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 归并排序
 *
 */
public class MergeSort {

    public void mergeSort(int[] nums, int left, int right) {
        // 终止条件, 左右边界相遇
        if (left >= right) {
            return;
        }

        // 计算中点
        int mid = left + right >> 1;

        // 分别排序左右两边; 左右边界如何确定: mid 为中点分开
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        // 归并排序结果数组, 最后是排好序的哦; 数组长度: 左右边界的长度
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, index = 0;

        // 归并排序循环条件:
        while (i <= mid && j <= right) {
            // 左边的数小于右边的数, 直接将左边的数加到 temp 数组
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                // 左边的数大于右边的数, 将右边的数加到 temp 数组
                temp[index++] = nums[j++];
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
    }

    @Test
    public void test1() {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48, 1};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test2() {
        int[] array = new int[]{0, 1, 2, 1};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

        int[] array1 = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48, 1};
        mergeSort(array1, 0, array1.length - 1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = {6, 5, 2, 7, 3, 9, 8, 4, 10, 1};
        mergeSort(array2, 0, array2.length - 1);
        System.out.println(Arrays.toString(array2));
    }
}
