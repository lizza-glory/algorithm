package com.lizza.Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 思路:
 * 1. 双端队列, 奇数层添加到队列首部, 偶数层添加到队列尾部
 */
public class LevelOrder3 {


    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 难点: 如何记录层数? 只需要把每一层的结果使用双端队列进行保存即可
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = queue.size(); i > 0 ; i--) {
                TreeNode node = queue.poll();
                // 双端队列, 奇数层添加到队列首部, 偶数层添加到队列尾部
                if (result.size() % 2 == 1) {
                    list.addFirst(node.val);
                } else {
                    list.addLast(node.val);
                }
                // 依次将当前节点的左右孩子加入队列
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    @Test
    public void test() throws Exception {
        System.out.println(0 % 2);
        System.out.println(1 % 2);
    }
}
