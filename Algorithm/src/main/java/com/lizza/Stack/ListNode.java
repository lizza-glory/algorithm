package com.lizza.Stack;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-24
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode next(ListNode node) {
        this.next = node;
        return this;
    }

    @Override
    public String toString() {
        return this.val + "";
    }
}
