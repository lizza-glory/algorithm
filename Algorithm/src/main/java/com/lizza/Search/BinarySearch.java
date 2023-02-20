package com.lizza.Search;

import org.junit.Test;

/**
 * 二分查找
 * 变体问题
 * 1. 寻找第一个等于 target 的位置
 * 2. 寻找最后一个等于 target 的位置
 * 3. 寻找第一个大于等于 target 的位置
 * 4. 寻找最后一个大于等于 target 的位置
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int start, int end, int target) {
        int mid = start + end >> 1;
        if (target < array[mid])
            return binarySearch(array, start, mid - 1, target);
        if (target > array[mid])
            return binarySearch(array, mid + 1, end, target);

        return mid;
    }

    public int findLastIndex(int[] array, int target) {
        int i = 0, j = array.length - 1;

        // 循环条件
        while (i <= j) {
            int mid = i + j >> 1;
            if (target >= array[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }

    @Test
    public void test1() throws Exception {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(array, 0, array.length - 1, 1));
        System.out.println(binarySearch(array, 0, array.length - 1, 3));
    }

    @Test
    public void test2() throws Exception {
        int start = 2, end = 6;
        System.out.println(start + end >> 1);
        System.out.println(start + (end >> 1));
        System.out.println((start + end) >> 1);
    }
}
