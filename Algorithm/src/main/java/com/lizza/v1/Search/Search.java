package com.lizza.v1.Search;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 链接: https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/description/?favorite=xb9nqhhg
 */
public class Search {

    public int search(int[] nums, int target) {
        return findLastIndex(nums, target) - findLastIndex(nums, target - 1);
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
}
