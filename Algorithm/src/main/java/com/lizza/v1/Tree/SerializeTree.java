package com.lizza.v1.Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 37. 序列化二叉树
 * 链接: https://leetcode.cn/problems/xu-lie-hua-er-cha-shu-lcof/description/?favorite=xb9nqhhg
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 示例：
 *      1
 *     / \
 *    2   3
 *       / \
 *      4   4
 *
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 *
 * 思路:
 * 使用前序遍历, 空节点使用特殊符号占位
 *
 */
public class SerializeTree {

    List<String> list = new ArrayList<>();
    public String serialize(TreeNode root) {
        encode(root);
        return list.toString();
    }

    public void encode(TreeNode root) {
        if (root == null) {
            list.add("#");
        } else {
            list.add(String.valueOf(root.val));
            encode(root.left);
            encode(root.right);
        }
    }

    int index = 0;
    public TreeNode deserialize(String data) {
        return decode();
    }

    public TreeNode decode() {
        String node = list.get(index++);
        if ("#".equals(node)) {
            return null;
        } else {
            TreeNode current = new TreeNode(Integer.parseInt(node));
            current.left = decode();
            current.right = decode();
            return current;
        }
    }



    @Test
    public void test1() throws Exception {
        TreeNode root = TreeNode.builder()
                .val(1)
                .left(TreeNode.builder().val(2).build())
                .right(TreeNode.builder().val(3)
                        .left(TreeNode.builder().val(4).build())
                        .right(TreeNode.builder().val(5).build())
                        .build())
                .build();
        deserialize(serialize(root));
    }
}
