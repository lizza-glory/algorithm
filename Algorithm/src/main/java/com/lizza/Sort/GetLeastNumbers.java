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
        int pivot = array[left], i = left, j = right;

        while (i < j) {
            while (array[j] >= pivot && i < j) {
                j--;
            }
            while (array[i] <= pivot && i < j) {
                i++;
            }
            swap(array, i, j);
        }
        swap(array, left, i);
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
}
