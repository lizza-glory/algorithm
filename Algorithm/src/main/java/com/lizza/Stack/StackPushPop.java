package com.lizza.Stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的
 * 弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的
 * 压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2}
 * 就不可能是该压栈序列的弹出序列。
 *
 * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 */
public class StackPushPop {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int e : pushed) {
            // 将目标数组元素压入栈
            stack.push(e);
            // 遍历检测数组是否与栈顶元素相同
            while (!stack.empty() && stack.peek() == popped[i]) {
                // 相同则出栈
                stack.pop();
                i++;
            }
        }
        return stack.empty();
    }

    @Test
    public void test1() {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,5,3,2,1};
        System.out.println(validateStackSequences(pushed, popped));
    }

    @Test
    public void test2() {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,3,5,1,2};
        System.out.println(validateStackSequences(pushed, popped));
    }
}
