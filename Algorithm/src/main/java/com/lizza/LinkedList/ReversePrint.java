package com.lizza.LinkedList;

import java.util.Arrays;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2021-01-08
 */
public class ReversePrint {

    public static void main(String[] args){
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        ListNode _4 = new ListNode(4);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        reversePrint(_1);
        System.out.println(Arrays.toString(result));
    }

    public static int[] reversePrint(ListNode head) {
        reverse(head);
        return result;
    }

    static int i = 0, j = 0;
    static int[] result;
    public static void reverse(ListNode head) {
        if (head == null) {
            result = new int[i];
            return;
        }
        i++;
        reverse(head.next);
        result[j++] = head.val;
    }
}
