package com.lizza.Sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 *
 * 思路:
 *
 */
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public void quickSort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left, j = right, pivot = array[left];
        while (i < j) {
            while (array[j] >= pivot && i < j) {
                j--;
            }
            array[i] = array[j];
            while (array[i] < pivot && i < j) {
                i++;
            }
            array[j] = array[i];
        }
        array[i] = pivot;
        quickSort(array, left, i - 1);
        quickSort(array, j + 1, right);
    }

    @Test
    public void test1() {
        int[] array = new int[]{3, 2, 1};
        int[] result = getLeastNumbers(array, 2);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void test2() {
        int[] array = new int[]{0, 1, 2, 1};
        int[] result = getLeastNumbers(array, 1);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void test3() {
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
