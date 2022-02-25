package com.lizza.Stack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 */
public class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    @Test
    public void test1() {
        queue = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

}
