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
 */
public class SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        // 从左向右, 从上向下, 从右向左, 从下向上打印
        // 左边界
        int l = 0;
        // 右边界
        int r = matrix[0].length - 1;
        // 上边界
        int t = 0;
        // 下边界
        int b = matrix.length - 1;

        // 结果
        int index = 0;
        int[] result = new int[(r + 1) * (b + 1)];

        // 难点: 边界碰撞跳出条件

        while (true) {
            // 从左向右, 打印上边界的那一行
            for (int i = l; i <= r; i++) {
                result[index++] = matrix[t][i];
            }
            // 打印完一行上边界向下移动
            if (++t > b) {
                break;
            }

            // 从上到下, 打印右边界的那一列
            for (int i = t; i <= b; i++) {
                result[index++] = matrix[i][r];
            }
            // 打印完一行右边界向左移动
            if (--r < l) {
                break;
            }

            // 从右到左, 打印下边界的那一行
            for (int i = r; i >= l; i--) {
                result[index++] = matrix[b][i];
            }
            // 打印完一行下边界向上移动
            if (--b < t) {
                break;
            }

            // 从下到上, 打印左边界的那一列
            for (int i = b; i >= t; i--) {
                result[index++] = matrix[i][l];
            }
            // 打印完一行左边界向右移动
            if (++l > r) {
                break;
            }
        }
        return result;
    }

    @Test
    public void test1() {
        int[][] array = new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        System.out.println(Arrays.toString(spiralOrder(array)));
    }
}
