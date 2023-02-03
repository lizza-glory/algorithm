package com.lizza.BitOpt;

import org.junit.Test;

/**
 * 获取指定数字的最接近的 2 的幂次方的数字; 比如给定 13 返回 16
 */
public class MaxNum {

    @Test
    public void test1() throws Exception {
        System.out.println(getMaxNum(13));
        System.out.println(getMaxNum(25));
        System.out.println(getMaxNum(1));
    }

    public static int getMaxNum(int num) {
        int result = 1;
        while (result <= num) {
            result <<= 1;
        }
        return result;
    }
}
