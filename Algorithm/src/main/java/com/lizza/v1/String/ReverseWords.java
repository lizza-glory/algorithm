package com.lizza.v1.String;

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
 *
 * 双指针遍历, 从尾部开始, 具体?
 * i, j 指针, i 向前移动, 到空格停止,
 *
 * 遍历完一个单词后, 怎么加入到结果集?
 * 利用 StringBuilder 的 append 方法
 *
 * 遍历完一个单词后, 怎么跳转到下一个结果集?
 * i 继续向前找字母, 找到后, j 移动过去
 *
 * 如何处理头部和尾部的空格?
 * 先 trim 去头尾空格
 *
 * 循环终止条件?
 * i == 0
 *
 * 中间多余空格如何去除
 * 找到单词后, 追加一个新空格即可
 */
public class ReverseWords {

    public String reverseWords(String s) {
        int j = s.length() - 1, i = j;
        StringBuilder result = new StringBuilder();
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

    @Test
    public void test3() throws Exception {
        System.out.println(' ' * 1);
        System.out.println('a' * 1);
        System.out.println('z' * 1);
        System.out.println('A' * 1);
        System.out.println('Z' * 1);
    }
}
