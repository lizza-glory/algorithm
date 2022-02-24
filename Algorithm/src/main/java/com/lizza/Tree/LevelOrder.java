package com.lizza.Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 */
public class LevelOrder {

    @Test
    public void test1() {
        System.out.println(levelOrder(TreeNode.getTree()));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        // 初始化时, 把根节点加入到队列中(先进先出)
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            // 遍历 queue, 将元素按先进先出的顺序加入 list, 最后将 list 加入 result
            // 难点: 此处要知道 queue.size() 在每次 add 后会变化, 所以使用 i = queue.size() 来缓存
            for (int i = queue.size(); i > 0 ; i--) {
                TreeNode node = queue.poll();
                list.add(node.val);

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
}
