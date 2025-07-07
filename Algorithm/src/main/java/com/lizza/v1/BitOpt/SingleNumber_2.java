package com.lizza.v1.BitOpt;

import org.junit.Test;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 *
 * 视频: https://www.bilibili.com/video/BV1Sg411r7GA/?spm_id_from=333.337.search-card.all.click&vd_source=b4974145db4a002a60536830f7890e47
 *
 * 思路
 * 1. 除了一个数组, 其他数字都出现了三次, 需要找到这个数字
 * 2. 将所有数字转为 2 进制, 求每一位的和, 记为 s, 然后求 s 和 3 的余数
 * 3. 将余数组成的 2 进制数转为 10 进制, 即结果
 * 4. 余数需要保存到一个长度为 32 的数组中
 */
public class SingleNumber_2 {

    public int singleNumber(int[] nums) {
        int[] array = new int[32];
        int m = 1, result = 0;
        for (int i = 0; i < 32; i++) {
            for (int num : nums) {
                if ((num & m) != 0) {
                    array[i]++;
                }
            }
            result += (array[i] % 3) * m;
            m <<= 1;
        }
        return result;
    }

    @Test
    public void test1() throws Exception {
        int[] nums = new int[]{1, 1, 2, 1};
        System.out.println(singleNumber(nums));
    }
}
