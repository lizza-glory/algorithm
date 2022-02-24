package com.lizza.Stack;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，
 * 并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，
 * 这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，
 * 其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 */
public class RemoveDuplicates {

    public String removeDuplicates(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuffer result = new StringBuffer();
        while (stack.size() > 0) {
            result.append(stack.pollLast());
        }
        return result.toString();
    }

    @Test
    public void test1() {
        System.out.println(removeDuplicates("abbaca"));
    }
}
