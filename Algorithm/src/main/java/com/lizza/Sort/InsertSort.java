package com.lizza.Sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 直接插入排序
 * 1. 遍历数组，将第i个元素缓存到tmp中，将第j个元素跟tmp进行比较
 *     如果第j位的元素比tmp大，则从该位置开始，将前一个位置的数据后移一位
 *     如果第j位的元素比tmp小，说明该位置的后一位就是第i个元素正确的位置
 * 折半插入排序
 * 1. 由于目标元素之前的元素(i - 1)是有序的, 查找目标元素位置时, 不再使用顺序查找的方式, 而是使用折半查找的方式提高效率
 * 2. 折半查找时, low = 0, high = i - 1
 * 希尔排序(还没弄明白)
 *
 */
public class InsertSort {

    public static void insertSort(int[] array) {
        int i, j, tmp;
        for (i = 0; i < array.length; i++) {
            tmp = array[i];
            // 查找位置, 移动元素
            for (j = i - 1; j >= 0 && array[j] > tmp; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = tmp;
        }
    }

    public static int binarySearch(int target, int[] array) {
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while (true) {
            mid = (high + low) / 2;
            if (target == array[mid]) {
                break;
            }
            if (low > mid || high < mid) {
                break;
            }
            if (target < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return mid;
    }

    public static void binaryInsertSort(int[] array) {
        int tmp;
        for (int i = 0; i < array.length; i++) {
            tmp = array[i];
            // 二分查找目标元素之前的数组, 找到正确的位置
            int low = 0;
            int high = i - 1;
            int mid;
            while (true) {
                mid = (high + low) / 2;
                if (tmp == array[mid]) {
                    break;
                }
                if (low > mid || high < mid) {
                    break;
                }
                if (tmp < array[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // 移动元素
            for (int j = i - 1; j >= high + 1; j--) {
                array[j + 1] = array[j];
            }
            array[high + 1] = tmp;
        }
    }

    @Test
    public void test1() {
        int[] array = {3, 2, 44, 38, 5, 47, 15, 36, 26, 27, 46, 4, 19, 50, 48};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test2() {
        int[] array = {2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50};
        for (int i : array) {
            System.out.println(binarySearch(i, array));
        }
    }

    @Test
    public void test3() {
        int[] array = {3, 2, 44, 38, 5, 47, 15, 36, 26, 27, 46, 4, 19, 50, 48};
        binaryInsertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
