package com.lizza.Array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 思路:
 * 1. 四个指针, 作为四个边界
 *      t: 上边界
 *      b: 下边界
 *      l: 左边界
 *      r: 右边界
 * 2. 难点:
 *      终止条件?
 *      边界移动? 死循环中执行, 执行完一行或者一列, 行列边界做移动
 *
 * 指针如何移动?
 * 从第一行开始, 从左往右, 从上往下, 从右往左, 从下往上依次进行
 *
 * 结果如何记录?
 * 使用数组记录
 *
 * 结果集数组, 长度如何确定
 * 二维数组的长度 * 二维数组中第一个元素的数组长度
 *
 * 遍历过程中, 完成了从左往右的过程, 再进行从上往下的遍历时, 结果集中元素如何确定坐标?
 * 使用单独的变量记录
 */
public class SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, index = 0;
        int[] result = new int[matrix.length * matrix[0].length];
        while (true) {
            // 从左往右遍历, 到右边界停止, 完成后, 上边界下移
            for (int i = l; i <= r; i++) {
                result[index++] = matrix[t][i];
            }
            if (t++ >= b) {
                break;
            }
            // 从上往下遍历, 到下边界停止, 完成后, 右边界左移
            for (int i = t; i <= b; i++) {
                result[index++] = matrix[i][r];
            }
            if (r-- <= l) {
                break;
            }
            // 从右往左遍历, 到左边界停止, 完成后, 下边界上移
            for (int i = r; i >= l; i--) {
                result[index++] = matrix[b][i];
            }
            if (b-- <= t) {
                break;
            }
            // 从下往上遍历, 到上边界停止, 完成后, 左边界右移
            for (int i = b; i >= t ; i--) {
                result[index++] = matrix[i][l];
            }
            if (l++ >= r) {
                break;
            }
        }
        return result;
    }

    @Test
    public void test1() {
        // 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        // 输出：[1,2,3,6,9,8,7,4,5]
        int[][] array = new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        System.out.println(Arrays.toString(spiralOrder(array)));
    }

    @Test
    public void test2() {
        // 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        int[][] array = new int[][]{
                {1,2,3,4},{5,6,7,8},{9,10,11,12}
        };
        System.out.println(Arrays.toString(spiralOrder(array)));
    }

    @Test
    public void test3() {
        // 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        int[][] array = new int[0][0];
        System.out.println(Arrays.toString(spiralOrder(array)));
    }
}
