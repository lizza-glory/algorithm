package com.lizza.String;

import org.junit.Test;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        StringBuffer result = new StringBuffer();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                result.append("20%");
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    @Test
    public void test1() {
        System.out.println(replaceSpace("We are happy."));
    }
}
