package com.lizza.LinkedList;

import org.junit.Test;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 示例 1
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 示例 2
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *
 * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 *
 * 解法:
 * 双指针互相遍历法, 直到两个指针相遇
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            // 难点: 两个没有交点的链表, 如何退出问题
            // 利用 null 值
            // a 如果不为 null, 则 a 向前移动一个节点, 直到 null 节点
            // a 如果为 null, 则移动到链表 B 的头节点
            a = (a == null ? headB : a.next);
            b = (b == null ? headA : b.next);
        }
        return a;
    }

    @Test
    public void test1() {
        ListNode headA = new ListNode(1)
                .next(new ListNode(2)
                .next(new ListNode(4)
                .next(new ListNode(5))));
        ListNode headB = new ListNode(6)
                .next(new ListNode(7)
                .next(new ListNode(4)
                .next(new ListNode(5))));
        System.out.println(getIntersectionNode(headA, headB));
    }
}
