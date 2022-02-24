package com.lizza.LinkedList;

import org.junit.Test;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
 * 即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的
 * 倒数第 3 个节点是值为 4 的节点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 *
 * 思路: 前后指针
 * 1. 链表长度为 n, 倒数第 k 个节点, 正数就是 n - k 的节点
 * 2. 前指针先走 k 步, 后指针开始和前指针一起走
 * 3. 后指针走了 n 步时, 前指针恰好走了 n - k 步, 即倒数第 k 个节点
 */
public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 前后指针同时指向头节点
        ListNode front = head;
        ListNode after = head;
        // 前指针先走 k 步
        while (--k > 0) {
            front = front.next;
        }
        // 前后指针一起走, 前指针为空时跳出, 后指针位于 n - k 处
        while (front.next != null) {
            front = front.next;
            after = after.next;
        }
        return after;
    }

    @Test
    public void test1() {
        ListNode _5 = new ListNode(5);
        ListNode _4 = new ListNode(4);
        ListNode _3 = new ListNode(3);
        ListNode _2 = new ListNode(2);
        ListNode _1 = new ListNode(1);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;
        ListNode result = getKthFromEnd(_1, 2);
        System.out.println(result.val);
    }
}
