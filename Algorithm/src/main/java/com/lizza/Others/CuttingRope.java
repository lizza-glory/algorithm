package com.lizza.Others;

import org.junit.Test;

/**
 * 剑指 Offer 14- I. 剪绳子
 *
 * 参考: https://www.bilibili.com/video/BV1EG411H736/?spm_id_from=333.337.search-card.all.click&vd_source=b4974145db4a002a60536830f7890e47
 *
 * 思路:
 * 1. 找规律或数学公式推演, 可以得出如下结论
 *    1. 所有子串长度为 3, 乘积最大
 *    2. n - 1 段长度为 3, 最后一段为 1, 需要从 n - 1 中拿出一段, 和最后一段拆成 2 * 2
 *    3. n - 1 段长度为 3, 最后一段为 2, 直接相乘即可
 */
public class CuttingRope {

    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int result = n / 3;
        int mod = n % 3;
        if (mod == 0) {
            return (int) (pow(3, result) % 1000000007);
        }
        if (mod == 1) {
            return (int) (pow(3, result - 1) * 4 % 1000000007);
        }
        if (mod == 2) {
            return (int) (pow(3, result) * 2 % 1000000007);
        }
        return -1;
    }

    public long pow(int m, int n) {
        long sum = 1;
        while (n-- > 0) {
            sum = (sum * m) % 1000000007;
        }
        return sum;
    }
    
    @Test
    public void test1() throws Exception {
        System.out.println(7/3);
        System.out.println(7%3);
    }

    @Test
    public void test2() throws Exception {
        System.out.println(pow(3, 0));
        System.out.println(pow(3, 1));
        System.out.println(pow(3, 2));
        System.out.println(pow(3, 3));
    }

    @Test
    public void test3() throws Exception {
        System.out.println(cuttingRope(4));
    }
}
