package com.lizza.v1.LinkedList;

/**
 *
 */
public class ListNode {

    public ListNode next;
    public int val;

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
