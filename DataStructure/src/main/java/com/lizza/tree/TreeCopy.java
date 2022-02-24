package com.lizza.tree;

import org.junit.Test;

/**
 * @Desc: 二叉树复制
 * @author: lizza.liu
 * @date: 2021-10-31
 */
public class TreeCopy {

    public Tree copy(Tree tree) {
        if (tree == null) {
            return null;
        } else {
            Tree result = new Tree(tree.value);
            result.left = copy(tree.left);
            result.right = copy(tree.right);
            return result;
        }
    }

    @Test
    public void test1() {
        Tree tree = Tree.initTree();
        Tree result = copy(tree);
        System.out.println("origin: ");
        Tree.preTraversal(tree);
        System.out.println("\nnow: ");
        Tree.preTraversal(result);
    }
}
