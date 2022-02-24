package com.lizza.Array;

import org.junit.Test;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-23
 */
public class FindNthDigit {

    public int findNthDigit(int n) {
        //
        for (int i = 0; i < n; i++) {
            int scale = 10;

            while (i%scale >= 0) {
                System.out.println(i);
                scale *= 10;
            }
        }
        return 1;
    }

    @Test
    public void test1() {
//        findNthDigit(19);
        System.out.println(19 / 100);
    }
}
