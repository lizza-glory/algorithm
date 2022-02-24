package com.lizza.Queue;

import org.junit.Test;

import java.util.LinkedHashMap;

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
 */
public class FirstUniqChar {


    public char firstUniqChar(String s) {
        if (s.isEmpty()) {
            return ' ';
        }
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, !map.containsKey(ch));
        }
        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue()).findFirst()
                .map(e -> e.getKey())
                .orElse(' ');
    }

    @Test
    public void test1() {
        System.out.println(firstUniqChar("aabbcc"));
        System.out.println(firstUniqChar(""));
        System.out.println(firstUniqChar("aadadaad"));
        System.out.println(firstUniqChar("abaccdeff"));
    }
}
