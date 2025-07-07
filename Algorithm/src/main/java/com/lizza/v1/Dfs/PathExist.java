package com.lizza.v1.Dfs;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 链接: https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/description/?favorite=xb9nqhhg
 *
 * 思路:
 * 1. 从矩阵左上角开始, 上左下右的顺序查找, 找到后, 重复上左下右, 且目标字符找下一个
 */
public class PathExist {

    public boolean exist(char[][] board, String word) {
        char[] array = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (dfs(board, array, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] array, int i, int j, int k) {
        // 边界条件：i，j 越界；字符已经遍历过；
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != array[k]) {
            return false;
        }

        // 结束处理：k 到了 array 的末尾
        if (k == array.length - 1) {
            return true;
        }

        // 代码执行到此处，说明 board 中 i，j 位置的元素和 array[k] 中相同，需要把当前位置进行特殊标记
        board[i][j] = '$';

        // 继续递归找下一个元素
        boolean result = dfs(board, array, i - 1, j, k + 1)
                || dfs(board, array, i, j - 1, k + 1)
                || dfs(board, array, i + 1, j, k + 1)
                || dfs(board, array, i, j + 1, k + 1);

        // 进行回退
        board[i][j] = array[k];

        return result;
    }
}
