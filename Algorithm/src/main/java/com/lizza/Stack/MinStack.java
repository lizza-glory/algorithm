package com.lizza.Stack;

import org.junit.Test;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min
 * 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 */
public class MinStack {

    int min;
    int index;
    int[] data;

    public MinStack() {
        min = Integer.MAX_VALUE;
        index = -1;
        data = new int[20000];
    }

    public void push(int x) {
        // 如果入栈元素小于最小元素, 则现将最小元素进行入栈
        if (x <= min) {
            data[++index] = min;
            min = x;
        }
        data[++index] = x;
    }

    public void pop() {
        // 如果出栈元素等于最小元素, 则将最小元素指向下一个元素
        if (min == data[index]) {
            min = data[--index];
        }
        index--;
    }

    public int top() {
        return data[index];
    }

    public int min() {
        return min;
    }

    @Test
    public void test1() {
        // ["MinStack","push","push","push","min","pop","top","min"]
        // [[],[-2],[0],[-3],[],[],[],[]]
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }

    @Test
    public void test2() {
        System.out.println(Integer.MAX_VALUE - 1 << 31);
    }
    
}
