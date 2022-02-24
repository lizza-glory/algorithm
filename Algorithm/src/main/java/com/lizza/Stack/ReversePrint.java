package com.lizza.Stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 链接: https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class ReversePrint {



    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.empty() && stack.peek() != null) {
            result[i++] = stack.pop();
        }
        return result;
    }

    @Test
    public void test1() {
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        _1.next = _2;
        _2.next = _3;
        int[] result = reversePrint(_1);
        System.out.println(Arrays.toString(result));
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


