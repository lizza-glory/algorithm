package com.lizza.tree;

import org.junit.Test;

/**
 * @Desc: 计算二叉树的深度
 * 分别计算左子树的深度 m, 右子树的深度 n, 整个树的深度为 m 和 n 中较大的值加 1
 * @author: lizza.liu
 * @date: 2021-10-31
 */
public class TreeDepth {

    public int depth(Tree tree) {
        if (tree == null) {
            return 0;
        } else {
            int m = depth(tree.left);
            int n = depth(tree.right);
            return m > n ? m + 1 : n + 1;
        }
    }

    @Test
    public void test1() {
        Tree tree = Tree.initTree();
        System.out.println(depth(tree));
    }
}
