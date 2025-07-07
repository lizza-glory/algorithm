package com.lizza.v1.Tree.Huffman;

import org.junit.Test;

/**
 * @Desc: 哈夫曼树, 顺序结构存储
 * @author: lizza.liu
 * @date: 2021-11-06
 */
public class Huffman {

    /**
     * n :8 权重: 7, 19, 2, 6, 32, 3, 21, 10
     */
    public static HTNode[] init() {
        HTNode[] array = new HTNode[15];
        array[0] = new HTNode(7);
        array[1] = new HTNode(19);
        array[2] = new HTNode(2);
        array[3] = new HTNode(6);
        array[4] = new HTNode(32);
        array[5] = new HTNode(3);
        array[6] = new HTNode(21);
        array[7] = new HTNode(10);
        return array;
    }

    /**
     * 构建 Huffman 树
     */
    public static HTNode[] build(int n, HTNode[] tree) {
        if (tree == null || tree.length == 0) {
            return null;
        }
        for (int i = n; i < tree.length; i++) {
            int[] indexArr = selectTwoMinElement(tree);
            tree[indexArr[0]].parent = i;
            tree[indexArr[1]].parent = i;
            tree[i] = new HTNode(tree[indexArr[0]].weight + tree[indexArr[1]].weight);
            tree[i].lNode = indexArr[0];
            tree[i].rNode = indexArr[1];
        }
        return tree;
    }

    /**
     * 两次遍历找到两个最小的元素
     * 时间复杂度: 2n^2
     */
    public static int[] selectTwoMinElement(HTNode[] tree) {
        if (tree == null || tree.length ==0) {
            return null;
        }
        int[] result = new int[2];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == null || tree[i].parent != 0) {
                continue;
            }
            if (tree[i].weight < tree[i1].weight) {
                i2 = i1;
                i1 = i;
            } else if (tree[i].weight < tree[i2].weight) {
                i2 = i;
            }
        }
        result[0] = i1;
        result[1] = i2;
        return result;
    }

    @Test
    public void test1() {
        HTNode[] trees = init();
        int[] result = selectTwoMinElement(trees);
        for (int i = 0; i < trees.length; i++) {
            System.out.println("i: " + i + ", weight: " + trees[i]);
        }
        System.out.println("i1: " + result[0] + ", i2: " + result[1]);
    }

    @Test
    public void test2() {
        HTNode[] tree = build(8, init());
        for (int i = 0; i < tree.length; i++) {
            System.out.println((i + 1) + "\t" + tree[i].weight + "\t" + tree[i].parent + "\t" + tree[i].lNode + "\t" + tree[i].rNode);
        }
    }
}
