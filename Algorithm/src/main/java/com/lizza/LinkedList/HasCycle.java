package com.lizza.LinkedList;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置
 * （索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false。
 *
 * 示例 1：
 *
 * 3 -> 2 -> 0-> -4
 *      ^         |
 *      |_________|
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 *
 * 思路:
 * 快慢指针
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 初始化时都指向头节点
        ListNode fast = head, slow = head;
        // 遍历条件: 快指针不为 null, 并且下一个节点不为 null
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
