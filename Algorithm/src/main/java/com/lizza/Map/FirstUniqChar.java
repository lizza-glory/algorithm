package com.lizza.Map;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 * s 只包含小写字母。
 *
 * 示例 1:
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 *
 * 输入：s = ""
 * 输出：' '
 *
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 *
 * 思路:
 * 1. 有序的 hash 表
 * 2. 数组, 数组的下标即字符对应的数字
 *      构建一个长度为 26 的数组
 *      遍历字符数组, 对应下标如果有字符, ++ 操作
 *      遍历数组, 结果为 1 就返回
 * 数组的话, 怎么保证第一个出现?
 *
 */
public class FirstUniqChar {


    public char firstUniqChar(String s) {
        int[] array = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            array[ch - 'a']++;
        }
        for (char ch : chars) {
            if (array[ch - 'a'] == 1) {
                return ch;
            }
        }
        return ' ';
    }
    public char firstUniqChar1(String s) {
        if (s.isEmpty()) {
            return ' ';
        }
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), !map.containsKey(s.charAt(i)));
        }
        return map.entrySet().stream()
                .filter(Map.Entry::getValue)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(' ');
    }

    @Test
    public void test1() {
        System.out.println(firstUniqChar("aabbcc"));
        System.out.println(firstUniqChar(""));
        System.out.println(firstUniqChar("aadadaad"));
        System.out.println(firstUniqChar("abaccdeff"));
    }

    @Test
    public void test2() throws Exception {
        System.out.println('a' * 1);
        System.out.println('z' * 1);
        System.out.println('A' * 1);
        System.out.println('Z' * 1);
    }
}
