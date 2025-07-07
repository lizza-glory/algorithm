package com.lizza.v1.Sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 * 1. 内层循环中 j - i 是为了减少循环次数,
 *    因为每次外层循环都会将最大的数字冒泡到最后的位置
 * 2. 内层循环中 j - i 再减去 1 是因为 i = 0 的时候
 *    j 最大可以取到 length - 1, j + 1 时数组越界
 */
public class BubbleSort {

    public static void bubbleSort(int[] array) {
        int tmp;
        for (int i = 0; i < array.length; i++) {
            //
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    @Test
    public void test1() {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}

