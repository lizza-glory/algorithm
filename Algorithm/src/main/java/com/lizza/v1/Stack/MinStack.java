package com.lizza.v1.Stack;

import org.junit.Test;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min
 * 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * <p>
 * 思路:
 * 最小元素如何记录?
 * 使用单独的变量进行记录
 * <p>
 * 整个元素如何存储?
 * 利用数组
 * <p>
 * 元素如何进栈和出栈?
 * 利用指针
 * <p>
 * 弹出时, 如果弹出的元素小于 min 如何处理
 * 不可能, min 在入栈时, 永远取得是最小元素
 * <p>
 * 如果弹出的元素正好是 min 元素, 如何处理?
 * 入栈时, 如果栈顶元素是最小元素, 则先将上一次的最小元素入栈, 然后入栈当前元素
 * 出栈时, 如果栈顶元素是最小元素, 则先进行出栈, 然后再出栈上一次的最小元素
 */
public class MinStack {

    int index;
    int min;
    int[] data;

    public MinStack() {
        index = 0;
        min = Integer.MAX_VALUE;
        data = new int[20000];
    }

    public void push(int x) {
        if (x <= min) {
            data[index++] = min;
            min = x;
        }
        data[index++] = x;
    }

    public void pop() {
        if (data[--index] == min) {
            min = data[--index];
        }
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
        // [[],[-3],[0],[-2],[],[],[],[]]
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
