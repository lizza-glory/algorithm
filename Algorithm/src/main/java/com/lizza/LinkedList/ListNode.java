package com.lizza.LinkedList;

/**
 *
 */
public class ListNode {

    ListNode next;
    int val;

    public ListNode () {
    }
    public ListNode (int val) {
        this.val = val;
    }

    public ListNode next(ListNode next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                "value=" + val +
                ", next=" + next +
                '}';
    }
}
