package com.lizza.Array;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，
 * 分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，
 * nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，
 * 应忽略。nums2 的长度为 n 。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 *
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 *
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 思路:
 * 1. 指针 i 指向 num1 尾部, 指针 j 指向 num2 尾部
 * 2. 移动 i, j 比较两数, 较大者放入 num1 尾部
 * 3. 终止条件: i, j 均小于 0
 *
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int l = m + n - 1;
        int cur;

        while (i >= 0 || j >= 0) {
            if (i == -1) {
                cur = nums2[j--];
            } else if (j == -1) {
                cur = nums1[i --];
            } else if (nums1[i] >= nums2[j]) {
                cur = nums1[i--];
            } else {
                cur = nums2[j--];
            }
            nums1[l--] = cur;
        }
    }
}
