package com.lizza.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2021-01-08
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode current = head;
        List<ListNode> list = new ArrayList<>();
        while (current != null) {
            list.add(current);
            current = current.next;
        }
        int size = list.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(size - 1 - i).val;
        }
        return result;
    }
}
