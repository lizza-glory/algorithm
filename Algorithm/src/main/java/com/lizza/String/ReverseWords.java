package com.lizza.String;

import org.junit.Test;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，
 * 标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
 * 则输出"student. a am I"。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出:"blue is sky the"
 *
 * 示例 2：
 *
 * 输入: " hello world! "
 * 输出:"world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 *
 * 输入: "a good  example"
 * 输出:"example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 *
 * 思路:
 * 1. 收尾指针去除: trim
 * 2. 中间多个空格只保留 1 个
 * 3. 双指针法切割单词
 * 4. 边界条件
 */
public class ReverseWords {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        s = s.trim();

        // 指针 i 用来寻找单词的左边界, j 用来寻找单词的右边界
        int i = s.length() - 1, j = i;
        StringBuilder result = new StringBuilder();

        // 终止条件 i < 0
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            result.append(s, i + 1, j + 1).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return result.toString().trim();
    }

    @Test
    public void test1() {
        System.out.println(reverseWords(" hello  world! "));
    }

    @Test
    public void test2() {
        System.out.println(reverseWords("a good   example"));
    }
}
