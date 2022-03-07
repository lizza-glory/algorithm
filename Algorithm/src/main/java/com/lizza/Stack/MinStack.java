package com.lizza.Stack;

import org.junit.Test;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min
 * 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
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
 * 思路:
 * 1. 利用数组
 * 2. 添加元素时如果是
 */
public class MinStack {

    int min;
    int[] data;
    int index;

    public MinStack() {
        min = Integer.MAX_VALUE;
        data = new int[20000];
        index = 0;
    }

    public void push(int x) {
        if (x <= min) {
            data[index++] = min;
            min = x;
        }
        data[index++] = x;
    }

    public void pop() {
        if (data[index - 1] == min) {
            index--;
            min = data[index - 1];
        }
        index--;
    }

    public int top() {
        return data[index - 1];
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
        //["MinStack","push","push","push","getMin","pop","getMin"]
        //[[],[0],[1],[0],[],[],[]]
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
    
}
