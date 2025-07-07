package com.lizza.v1.LinkedList;

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
 * 思路:
 * 1. 双指针, 前后指针; 后指针的 next 指向前节点, 然后两个指针向后移动
 * 2. 终止条件, 后指针的 next 为 null
 *
 * 如何将当前节点的下一个节点指向前一个?
 * current.next = before
 *
 * 如何移动当前节点?
 * current = next
 *
 * 如何移动前一个节点?
 * before = current, 但是需要注意, before 的移动必须在 current 之前
 *
 * 最终的结果?
 * before
 *
 * 终止条件?
 * current = null
 *
 * before 初始化
 * before 初始化为 null, 指向 head 死循环
 *
 * 思考:
 * 1. java 引用传递和值传递:
 *      ListNode tmp = current.next;
 *      current.next = before;
 *    tmp 指向 current.next 指向的对象
 *    current.next = before 将 next 指针指向 before 指向的对象
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode before = head, current = head;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = before;
            before = current;
            current = tmp;
        }
        return before;
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
