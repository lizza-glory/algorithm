package com.lizza.tree;

import org.junit.Test;

/**
 * @Desc: 树的节点个数计算
 * @author: lizza.liu
 * @date: 2021-10-31
 */
public class TreeNodeCount {

    public int count(Tree tree) {
        if (tree == null) {
            return 0;
        } else {
            return count(tree.left) + count(tree.right) + 1;
        }
    }

    @Test
    public void test1() {
        System.out.println(count(Tree.initTree()));
    }
}
