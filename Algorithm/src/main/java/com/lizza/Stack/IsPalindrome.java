package com.lizza.Stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，
 * 返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 1 -> 2 -> 2 -> 1
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 *
 * 1 -> 2
 * 输入：head = [1,2]
 * 输出：false
 *
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 思路:
 * 1. 将数据复制到数组, 利用双指针
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current);
            current = current.next;
        }

        // 收尾指针
        int i = 0, j = list.size() - 1;

        while (i < j) {
            if (list.get(i).val != list.get(j).val) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    @Test
    public void test1() {
        ListNode node = new ListNode(1)
                .next(new ListNode(2)
                .next(new ListNode(2)
                .next(new ListNode(1))));
        System.out.println(isPalindrome(node));
    }

    @Test
    public void test2() {
        ListNode node = new ListNode(1);
        System.out.println(isPalindrome(node));
    }

    @Test
    public void test3() {
        ListNode node = new ListNode(1)
                .next(new ListNode(0)
                        .next(new ListNode(1)));
        System.out.println(isPalindrome(node));
    }
}
