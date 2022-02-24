package com.lizza.LinkedList;

import org.junit.Test;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 初始化时, 将 current 指向头节点,
        // 要解决的问题: 如果没有 current 节点, 只使用 head 那么最后是不知道头节点到底在哪
        ListNode head = new ListNode(), current = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 当两个链表不一样长的时候, 需要把较长的那个(必定没有遍历完成) 接到 current 的后边
        current.next = (l1 == null ? l2 : l1);

        // 返回头节点的下一个节点
        return head.next;
    }

    @Test
    public void test1() {
        ListNode l1 = new ListNode(1)
                .next(new ListNode(2)
                        .next(new ListNode(4)));
        ListNode l2 = new ListNode(1)
                .next(new ListNode(3)
                        .next(new ListNode(4)
                                .next(new ListNode(6))));
        System.out.println(mergeTwoLists(l1, l2));
    }
}
