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
        // 难点: 终止条件是左边界超过了右边界
        if (left > right) {
            return;
        }
        // 找基准, 一般是数组的第一个元素
        int pivot = array[left];
        // 确定左右指针, 从数组的左右两端开始
        int i = left, j = right;
        // 循环成立的条件, 左指针不能超过右指针
        while (i < j) {
            // 难点: 必须是右指针先开始遍历, 右指针从右向左遍历, 找到比 pivot 小的数
            while (array[j] >= pivot && i < j) {
                j--;
            }
            // 左指针从左向右遍历, 找到比 pivot 大的数
            while (array[i] <= pivot && i < j) {
                i++;
            }
            // 左右指针找到两个数之后, 进行交换
            // 难点: 交换时需要确定左右指针没有越界?
            swap(array, i, j);
        }
        // 难点: 指针重合(越过) 对 pivot 的处理?
        // 指针 i, j 重合时, pivot 放在 i 或者 j 的位置
        swap(array, left, i);

        // 对左子表进行递归排序
        quickSort(array, left, i - 1);
        // 对右子表进行递归排序
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
