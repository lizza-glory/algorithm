package com.lizza.v2.link;

import com.lizza.v1.LinkedList.ListNode;

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode i = headA, j = headB;
        while (i != j) {
            i = i == null ? headB : i.next;
            j = j == null ? headA : j.next;
        }
        return i;
    }
}
