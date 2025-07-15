package com.lizza.v2.array;

import org.junit.Test;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            if (x == num) {
                votes++;
            } else {
                votes--;
            }
        }
        return x;
    }

    @Test
    public void test1() throws Exception {
        int nums[] = new int[]{1,3,1,1,4,1,1,5,1,1,6,2,2};
        System.out.println(majorityElement(nums));
    }
}
