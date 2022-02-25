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
        index = -1;
    }

    public void push(int val) {
        // 添加元素时, 如果该元素小于或者等于最小值, 那么先把最小值添加到数组中
        // 然后把最小值改为该元素
        if (val <= min) {
            data[++index] = min;
            min = val;
        }
        data[++index] = val;
    }

    public void pop() {
        // 删除栈顶元素, 如果栈顶元素是最小值, 那么需要把最小值置为下一个元素
        // 并且指针移动两个位置
        if (data[index] == min) {
            min = data[--index];
        }
        --index;
    }

    public int top() {
        return data[index];
    }

    public int getMin() {
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
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    @Test
    public void test2() {
        //["MinStack","push","push","push","getMin","pop","getMin"]
        //[[],[0],[1],[0],[],[],[]]
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
    
}
