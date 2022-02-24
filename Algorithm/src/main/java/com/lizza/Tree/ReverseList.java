package com.lizza.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2021-01-13
 */
public class ReverseList {

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        ListNode _4 = new ListNode(4);
        head.next = _2;
        _2.next = _3;
        _3.next = _4;

        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        for (int i = list.size() - 1; i > 0; i--) {
            ListNode cur = list.get(i);
            cur.next = list.get(i - 1);
        }
        ListNode result = list.get(list.size() - 1);
        System.out.println(result);
    }

    static class ListNode {

        ListNode next;
        int value;
        public ListNode (int value) {
            this.value = value;
        }
    }

}
