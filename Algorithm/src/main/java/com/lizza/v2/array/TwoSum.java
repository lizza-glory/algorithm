package com.lizza.v2.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{0};
    }

    @Test
    public void test1() throws Exception {
        int[] nums = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    @Test
    public void test2() throws Exception {
        int[] nums = new int[]{3,2,4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }
}
