package com.lizza.tree;

import org.junit.Test;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-10-24
 */
public class BinaryTree {

    // 递归: 先序遍历 1245736
    @Test
    public void test1() {
        Tree tree = Tree.initTree();
        Tree.preTraversal(tree);
    }

    // 递归: 中序遍历 4257163
    @Test
    public void test2() {
        Tree tree = Tree.initTree();
        Tree.midTraversal(tree);
    }

    // 递归: 后序遍历 1245736
    @Test
    public void test3() {
        Tree tree = Tree.initTree();
        Tree.tailTraversal(tree);
    }

    // 循环: 中序遍历 4257163
    @Test
    public void test4() {
        Tree tree = Tree.initTree();
        Tree.loopTraversal(tree);
    }

    // 循环: 层序遍历 1234567
    @Test
    public void test5() {
        Tree tree = Tree.initTree();
        Tree.levelTraversal(tree);
    }
}
