package com.lizza.Sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 快速排序
 * 1. 找基准: pivot, 一般是数组的第一个元素
 * 2. 定指针: i, j; i 表示从左边找比 pivot 大的数的位置; j 表示从右边比 pivot 小的数
 * 3. 做交换: i, j 各自找到对应的数之后, i, j 位置的数交换
 * 4. i, j 重合后, 将 pivot 放置在重合位置
 * 5. 以 pivot 为分界线, 递归对子表排序
 */
public class QuickSort {

    public void quickSort(int[] array, int left, int right) {
        // 终止条件: 左右边界越界
        if (left > right) {
            return;
        }
        int i = left, j = right, pivot = array[left];
        while (i < j) {
            // pivot 选取的是左边元素, 从右边开始遍历, 且需要考虑重复情况
            while (array[j] >= pivot && i < j) {
                j--;
            }
            // 找到了比 pivot 小的元素, 和 array[i] 互换, array[i] 的值在 pivot 中
            array[i] = array[j];
            while (array[i] < pivot && i < j) {
                i++;
            }
            // 找到了比 pivot 大的元素, 和 array[j] 互换, array[j] 的值已经放到 array[i] 了
            array[j] = array[i];
        }
        // i j 重合, 需要将 pivot 放到 array[i]
        array[i] = pivot;
        quickSort(array, left, i - 1);
        quickSort(array, j + 1, right);
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Test
    public void test1() {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48, 1};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test2() {
        int[] array = new int[]{0, 1, 2, 1};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

        int[] array1 = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48, 1};
        quickSort(array1, 0, array1.length - 1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = {6, 5, 2, 7, 3, 9, 8, 4, 10, 1};
        quickSort(array2, 0, array2.length - 1);
        System.out.println(Arrays.toString(array2));
    }
}
