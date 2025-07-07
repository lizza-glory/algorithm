package com.lizza.v1.Array;

import org.junit.Test;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 限制：
 *
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 *
 * 思路: 将矩阵逆时针旋转, 将右上角元素(也可以是左下角)当做根节点, 看做一颗树, 可以发现
 * 左边元素比根节点小, 右边比根节点大, 根据这个特点进行算法设计
 *
 * 选定跟节点 flag(15), 坐标为: (i, j) = (0, 4)
 * 如果 target > flag, i++
 * 如果 target < flag, j--
 *
 * 边界条件: i < matrix[0].length, j < matrix.length
 *
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1, flag = matrix[i][j];
        while (i < matrix.length && j >= 0) {
            if (target == flag) {
                return true;
            }
            if (target > flag) {
                i++;
            } else {
                j--;
            }
            if (i < matrix.length && j >= 0) {
                flag = matrix[i][j];
            }
        }
        return false;
    }

    @Test
    public void test1() throws Exception {
        int[][] array = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(array, 20));
        System.out.println(findNumberIn2DArray(array, 5));
    }

    @Test
    public void test2() throws Exception {
        int[][] array = new int[][]{
                {1, 1}
        };
        System.out.println(findNumberIn2DArray(array, 2));
        System.out.println(findNumberIn2DArray(array, 1));
    }

    @Test
    public void test3() throws Exception {
        int[][] array = new int[][]{
                {5}, {6}
        };
        System.out.println(findNumberIn2DArray(array, 6));
        System.out.println(findNumberIn2DArray(array, 1));
    }
}
