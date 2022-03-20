package com.lizza.String;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 思路:
 * 1. 长度统计: 双指针+滑动窗口
 * 2. 重复字符: hashMap
 * 3. 难点: 对于 pwwkew 这种, 碰到第三个 w 时, 需要把前指针指向前一个 w
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int n = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                n = Math.max(map.get(s.charAt(i)), n);
            }
            map.put(s.charAt(i), i);
            result = Math.max(result, i - n);
        }
        return result;
    }

    @Test
    public void test1() {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    @Test
    public void test2() {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    @Test
    public void test3() {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
