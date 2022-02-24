package com.lizza.Search;

import org.junit.Test;

/**
 * 二分查找
 * 设 n 为表长, low 为下界(下标), high 为上界(下标), mid 为中间节点位置(下标), key 为目标元素
 * 比较中间元素和 mid 位置元素的大小
 *     若 key 小于 mid, 在前半区继续查找, high = mid - 1
 *     若 key 大于 mid, 在后半区继续查找, low = mid + 1
 *     若 key 等于 mid, 找到, 返回
 * 终止条件:
 *     high < mid 或者 low > mid
 * 易错点:
 *     mid 的计算: x - low = high - x
 *     x = (low + high) / 2
 */
public class BinSearch {


    /**
     * 循环的方式二分查找
     */
    @Test
    public void test1() {
        int[] array = new int[]{3, 7, 17, 24, 39, 58, 67, 71, 76, 81, 99};
        for (int i : array) {
            System.out.println(binSearch(array, i, 0, array.length - 1));
        }
        System.out.println(binSearch(array, -1, 0, array.length - 1));
        System.out.println(binSearch(array, 100, 0, array.length - 1));
    }

    public static int binSearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (true) {
            int mid = (low + high) / 2;
            if (key == array[mid]) {
                return mid;
            }
            if (high < mid || low > mid) {
                break;
            }
            if (key > array[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binSearch(int[] array, int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (array[mid] == key) {
            return mid;
        }
        if (key > array[mid]) {
            return binSearch(array, key, mid + 1, high);
        } else {
            return binSearch(array, key, low, mid - 1);
        }
    }
}
