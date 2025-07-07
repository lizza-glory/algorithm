package com.lizza.v1.Queue;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入: 
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 *
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 */
public class MaxQueue {

    /** 正常队列 **/
    Queue<Integer> queue = new LinkedList<>();

    /** 递减队列, 保存最大值 **/
    Deque<Integer> deque = new LinkedList<>();

    public MaxQueue() {}

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    /**
     * 队尾入队元素时
     * 1. queue 正常入队
     * 2. deque 判断队尾元素是否小于入队元素, 如果小于当前入队元素, 则将队尾元素
     *    进行移除
     */
    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offer(value);
    }

    /**
     * 1. queue 正常出队
     * 2. 递减队列判断出队元素是否与队首元素相同, 若相同, 则需要出队
     */
    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        Integer result = queue.poll();
        if (result.equals(deque.peekFirst())) {
            deque.pollFirst();
        }

        return result;
    }

    /**
     * 输入:
     * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
     * [[],[1],[2],[],[],[]]
     * 输出: [null,null,null,2,1,2]
     * ["MaxQueue","max_value","pop_front","pop_front","push_back","push_back","push_back","pop_front","push_back","pop_front"]
     * [[],[],[],[],[94],[16],[89],[],[22],[]]
     */
    @Test
    public void test1() {
        MaxQueue queue = new MaxQueue();
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        System.out.println(queue.pop_front());
        queue.push_back(94);
        queue.push_back(16);
        queue.push_back(89);
        System.out.println(queue.pop_front());
        queue.push_back(22);
        System.out.println(queue.pop_front());
    }
}
