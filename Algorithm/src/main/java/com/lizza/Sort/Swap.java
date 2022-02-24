package com.lizza.Sort;

import java.util.Arrays;

/**
 * 交换数字的三种方式
 * 1. 临时变量法
 * 2. 算数法
 * 3. 位运算法
 */
public class Swap {

    public static void main(String[] args){

        // 临时变量法
        int[] array1 = new int[]{4, 9};
        swapByTemp(array1, 0, 1);
        System.out.println(Arrays.toString(array1));

        // 算数法
        int[] array2 = new int[]{192, -17};
        swapByArithmetic(array2, 0, 1);
        System.out.println(Arrays.toString(array2));

        // 位运算法(按位异或)
        int[] array3 = new int[]{3, 7};
        swapByBit(array3, 0, 1);
        System.out.println(Arrays.toString(array3));
    }

    public static void swapByTemp(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void swapByArithmetic(int[] array, int i, int j) {
        array[i] = array[i] + array[j];
        array[j] = array[i] - array[j];
        array[i] = array[i] - array[j];
    }

    /**
     * 按位异或计算进行数据交换: 7, 3
     * 7:   0111
     * 3:   0011
     * L    0111 ^ 0011 = 0100  4
     * R    0100 ^ 0011 = 0111  7
     * L    0100 ^ 0111 = 0011  3
     */
    private static void swapByBit(int[] array, int left, int right) {
        array[left] = array[left] ^ array[right];
        array[right] = array[left] ^ array[right];
        array[left] = array[left] ^ array[right];
    }
}
