package com.lizza.LinkedList;

import org.junit.Test;

/**
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，
 * 然后返回重新排序的列表。
 *
 * 第一个节点的索引被认为是奇数 ， 第二个节点的索引为偶数 ，以此类推。
 *
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 *
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 *
 * 示例 1
 * 1 > 2 > 3 > 4 > 5
 *
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 *
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 思路:
 * 1. 初始:
 *      1. 定义奇偶指针: odd(奇数), even(偶数), 以及偶数节点的头指针 evenHead
 *         用于接入到奇数链表的尾部
 *      2. 奇数指针指向 head, 偶数指针指向 head.next
 * 2. 移动奇偶指针
 *      1. 移动奇数指针: 奇数指针的下一个节点指向偶数的下一个节点, 然后更新当前奇数指针
 *      2. 移动偶数指针: 同奇数
 * 3. 将偶数头指针接到当前奇数节点的尾部
 * 4. 终止条件: 偶数指针为 null 或者 偶数指针的下一个为 null
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head, even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    @Test
    public void test1() throws Exception {
        ListNode head = new ListNode(1)
                .next(new ListNode(2)
                .next(new ListNode(3)
                .next(new ListNode(4)
                .next(new ListNode(5)))));
        System.out.println(oddEvenList(head));
    }
}
