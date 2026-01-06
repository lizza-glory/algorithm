package com.lizza.v2.window;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目链接: https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-100-liked
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] array = s.toCharArray();
        int l = 0, result = 1;
        while (l < array.length) {
            int r = l + 1;
            Set<Character> set = new HashSet<>();
            set.add(array[l]);
            while (r < array.length && !set.contains(array[r])) {
                set.add(array[r]);
                result = Math.max(result, r - l + 1);
                r++;
            }
            set.remove(array[l]);
            l++;
        }
        return result;
    }

    @Test
    public void test1() throws Exception {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
