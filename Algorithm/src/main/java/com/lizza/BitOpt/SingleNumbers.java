package com.lizza.BitOpt;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 题目: 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，
 * 空间复杂度是O(1)。
 * 链接: https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * 视频链接: https://www.bilibili.com/video/BV1sa41197oH/?spm_id_from=333.337.search-card.all.click&vd_source=b4974145db4a002a60536830f7890e47
 *
 * 思路
 * 1. 如果在数组中[1, 1, 2, 2, 3]求一个元素, 与其他元素不同, 解法为: 所有元素异或, 最终会得到不同的元素 3
 * 2. 如果在数组中[1, 1, 2, 2, 3, 4]求两个元素, 与其他元素不同, 解法为: 将 3 和 4 设法分到两个个数组, 然后单独使用步骤 1
 * 3. 如何将 3 和 4 分到两个数组?
 *    1. 设 x, y 为不同的两个元素, z = x ^ y
 *    2. z 中各个位, 为 1 说明 x 和 y 对应的位不同
 *    3. 从 z 中找到不同的最低的哪一位, 记为 m
 *    4. m 与数组中所有元素做与运算, 假设为 0 是 x 一组的, 为 1 是 y 一组的, 这样就把 x, y 分开到两个组
 *    5. 分别对两个组做异或运算
 */
public class SingleNumbers {

    public int[] singleNumbers(int[] nums) {
        int z = 0;
        for (int num : nums) {
            z ^= num;
        }

        // 从第一位开始找, 如果相同, 继续往后找
        int m = 1;
        // z 和 m 不同, 说明 x 和 y 对应位置相同
        while ((z & m) == 0) {
            m <<= 1;
        }

        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & m) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }


}
