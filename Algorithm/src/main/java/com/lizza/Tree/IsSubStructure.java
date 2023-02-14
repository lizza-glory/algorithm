package com.lizza.Tree;

/**
 * 剑指 Offer 26. 树的子结构
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * 思路
 * 判断 B 是不是 A 的子结构, 等价于:
 * 1. B 和 A 完全相同
 * 2. B 和 A 的左子树相同
 * 3. B 和 A 的右子树相同
 * 三个条件满足任一即可
 *
 * B 和 A 完全相同, 等价于
 * 1. A 和 B 值相同
 * 2. A 的左子树和 B 的左子树相同
 * 3. A 的右子树和 B 的右子树相同
 * 三个条件必须全部满足
 *
 * 主函数边界条件?
 * A == null 或者 B == null 表示不相同
 *
 * helper 函数边界条件?
 * B 为 null, 说明把 B 遍历完了, 返回 true(这块为啥返回 true 需要继续思考下)
 * A 为 null, 说明 B 没有遍历完, 但是 A 遍历完了, 结构肯定不一样, 返回 false
 */
public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean helper(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        return A.val == B.val && helper(A.left, B.left) && helper(A.right, B.right);
    }
}
