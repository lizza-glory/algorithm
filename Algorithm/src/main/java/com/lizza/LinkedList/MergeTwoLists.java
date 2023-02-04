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
 * 思路:
 * 1. 双指针遍历两个链表,
 * 2. 边界条件: 只要有一个链表遍历完成就终止
 * 3. 将未遍历完成的链表接到结果链表后边
 *
 * 双指针问题
 * 这里双指针复用 l1 和 l2
 *
 * p1 和 p2 遍历链表, 如何比较大小, 比较完如何处理?
 * 谁的值小, 新链表指向谁, 比较完之后, 移动指针
 *
 * 一轮比较完成后, current 如何移动
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(), current = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current = l1;
                l1 = l1.next;
            } else {
                current = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current = l1;
        }
        if (l2 != null) {
            current = l2;
        }
        return head;
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
