package com.lizza.LinkedList;

import org.junit.Test;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 *
 * 思路: 双指针, 前后指针
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            // 缓存当前节点的下一个节点
            ListNode tmp = cur.next;
            // 将当前节点的下一个节点指向前一个节点
            cur.next = pre;
            // 将前一个节点指向当前节点
            pre = cur;
            // 移动当前节点到下一个节点
            cur = tmp;
        }
        return pre;
    }

    @Test
    public void test1() {
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        ListNode _4 = new ListNode(4);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        System.out.println(reverseList(_1));
    }
}
