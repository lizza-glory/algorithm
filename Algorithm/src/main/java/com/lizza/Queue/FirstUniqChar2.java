package com.lizza.Queue;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，
 * 则返回 -1 。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 *
 * 输入: s = "aabb"
 * 输出: -1
 *
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 */
public class FirstUniqChar2 {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            Integer count = map.getOrDefault(ch, 0);
            map.put(ch, ++count);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test1() {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

}
