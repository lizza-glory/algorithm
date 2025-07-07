package com.lizza.v1.String;

import org.junit.Test;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 思路:
 * 1. 纵向遍历: 即以第一个元素为基准, 从第一个 char 开始遍历所有元素
 * 2. 难点:
 *      数组中只有一个元素时, 需要返回其本身
 *      数组中所有元素都相同时, 需要返回第一个元素
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || ch != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    @Test
    public void test1() throws Exception {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    @Test
    public void test2() throws Exception {
        String[] strs = new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    @Test
    public void test3() throws Exception {
        String[] strs = new String[]{"a"};
        System.out.println(longestCommonPrefix(strs));
    }

    @Test
    public void test4() throws Exception {
        String[] strs = new String[]{"ab", "a"};
        System.out.println(longestCommonPrefix(strs));
    }
}
