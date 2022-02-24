package com.lizza.Tree;

import org.junit.Test;

import java.util.*;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 *
 * 思路
 * 1. 利用队列的先进先出的特点
 */
public class LevelOrder2 {

    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        List<Integer> result = new ArrayList<>();
        // 难点: 循环条件的判断, 以及元素的添加
        // 循环条件: 只要当前队列中有值, 就继续循环
        while (!queue.isEmpty()) {
            //
            for (int i = queue.size(); i > 0 ; i--) {
                // 拿出队首元素
                TreeNode node = queue.poll();
                result.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void test1() {
        System.out.println(Arrays.toString(levelOrder(TreeNode.getTree())));
    }
}
