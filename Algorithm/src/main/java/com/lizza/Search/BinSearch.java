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
     * 给定排序数组和目标, 在数组中二分法查找目标数对应的下标
     * l 表示左边界, r 表示右边界
     */
    public int binSearch(int[] array, int target) {
        int l = 0, r = array.length - 1;
        while (true) {
            int m = (r + l) / 2;
            if (array[m] == target) {
                return m;
            }
            if (l > m || r < m) {
                break;
            }
            if (target > array[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    /**
     * 二分法查找给定元素的下标
     * low 左边界, high 右边界, mid 中间位置
     * 终止条件:
     * 1. 找到了, 直接返回
     * 2. 左右边界越界了, 返回-1
     */
    public int binSearch(int[] array, int key, int low, int high) {
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

    @Test
    public void test1() {
        int[] array = new int[]{3, 7, 17, 24, 39, 58, 67, 71, 76, 81, 99};
        for (int i : array) {
            System.out.println(binSearch(array, i, 0, array.length - 1));
        }
        System.out.println(binSearch(array, -1, 0, array.length - 1));
        System.out.println(binSearch(array, 100, 0, array.length - 1));
    }

    @Test
    public void test2() {
        int[] array = new int[]{3, 7, 17, 24, 39, 58, 67, 71, 76, 81, 99};
        for (int i : array) {
            System.out.println(binSearch(array, i));
        }
        System.out.println(binSearch(array, -1));
        System.out.println(binSearch(array, 100));
    }

    @Test
    public void test3() {
        int[] array = new int[]{5,7,7,8,8,10};
        System.out.println(binSearch(array, 8));
    }
}
