package com.lizza.Map;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个数组, 内有多个重复的数字, 寻找重复次数最多的 n 个数, 要求倒序排列
 */
public class RepeatNums {

    public int[] repeatNums(int[] array, int count) {
        Map<Integer, Integer> map = new HashMap<>();
        // O(n)
        for (int num : array) {
            Integer value = map.getOrDefault(num, 0);
            map.put(num, value + 1);
        }
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        // O(n)
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            treeMap.computeIfAbsent(value, i -> new ArrayList<>()).add(key);
        }
        int[] result = new int[count];
        //
        while (count > 0) {
            List<Integer> list = treeMap.pollLastEntry().getValue();
            Collections.sort(list, Comparator.comparingInt(o -> -o));
            for (Integer num : list) {
                if (--count < 0) {
                    break;
                }
                result[count] = num;
            }
        }

        return result;
    }

    // 摩尔投票法: 不能解决排序
    Set<Integer> set = new HashSet<>();
    int count;
    public void vote(int[] array) {
        if (count-- == 0) {
            return;
        }
        int vote = 0, result = 0;
        for (int num : array) {
            if (set.contains(num)) {
                continue;
            }
            if (vote == 0) {
                result = num;
            }
            vote += (result == num ? 1 : -1);
        }
        set.add(result);
        vote(array);
    }

    @Test
    public void test1() throws Exception {
        int[] array = {6, 5, 2, 7, 3, 9, 8, 4, 10, 1, 5, 3, 9};
        System.out.println(Arrays.toString(repeatNums(array, 4)));
    }

    @Test
    public void test2() throws Exception {
        int[] array = {6, 5, 2, 7, 3, 9, 8, 4, 10, 1, 5, 3, 9};
        count = 2;
        vote(array);
        int[] arr = set.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(arr));
    }
}
