package com.lizza.LinkedList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 思路: 遍历链表, 利用数组存放, 反向遍历数组, 输出结果
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current);
            current = current.next;
        }
        int[] result = new int[list.size()];
        for (int i = list.size(); i > 0; i--) {
            result[list.size() - i] = list.get(i - 1).val;
        }
        return result;
    }

    @Test
    public void test1() throws Exception {
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        _1.next = _2;
        _2.next = _3;
        int[] result = reversePrint(_1);
        System.out.println(Arrays.toString(result));
    }
}
