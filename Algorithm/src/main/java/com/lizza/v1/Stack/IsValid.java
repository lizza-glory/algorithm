package com.lizza.v1.Stack;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否
 * 有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class IsValid {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        map.put('?', '?');

        Stack<Character> stack = new Stack<>();
        stack.push('?');
        for (char ch : s.toCharArray()) {
            // 左括号入栈
            if (map.containsKey(ch)) {
                stack.push(ch);
            } else if (map.get(stack.pop()) != ch) {
                // 右括号出栈
                // 难点: 需要明确的是右括号需要特殊处理
                return false;
            }

        }

        //
        return stack.size() == 1;
    }

    @Test
    public void test1() {
        System.out.println(isValid("]"));
    }
}
