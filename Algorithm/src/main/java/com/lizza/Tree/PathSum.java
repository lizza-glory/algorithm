package com.lizza.Tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 链接: https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/description/?favorite=xb9nqhhg
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 *
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *
 * 提示：
 *
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
 * 思路:
 * 利用先序遍历, 将每条路径上的元素进行求和, 其和与给定的值比较, 相同则将路径加入结果集
 *
 * 如何递归计算和?
 *
 *
 * 如何保存路径?
 * 定义两个变量来保存
 *
 * 边界条件?
 * root 为 null
 *
 * 不满足的叶子节点如何处理?
 * 从 path 中移除
 *
 * 不满足的叶子节点从 path 中移除后, target 如何处理?
 * target 不用处理,
 */
public class PathSum {

    LinkedList<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recursive(root, target);
        return result;
    }

    public void recursive(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new LinkedList<>(path));
        }
        recursive(root.left, target);
        recursive(root.right, target);
        // 不满足的叶子节点, 从 path 中移除
        path.removeLast();
    }

    @Test
    public void test1() throws Exception {
        
    }
}
