package com.lizza.Map;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个整数数组 nums 和一个整数 k，
 * 请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 链接：https://leetcode-cn.com/problems/g5c51o
 * 思路:
 * 1. 利用 map 统计得到数字的出现频率
 * 2. 利用大顶堆存储元素出现次数和元素关系, 大顶堆中存储数组
 *      下标为 0 存储次数
 *      下标为 1 存储元素
 * 3. 遍历大顶堆, 得到 top k
 */
public class TopKFrequent {

    // 大顶堆实现
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((arr1, arr2) -> arr2[0] - arr1[0]);
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            queue.offer(new int[]{value, key});
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[1];
        }
        return result;
    }

    @Test
    public void test1() throws Exception {
        int[] arr = new int[]{1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(arr, 2)));
    }
}
