package com.lizza.v1.Tree.Huffman;

import lombok.Data;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-11-06
 */
@Data
public class HTNode {

    public int parent;
    public int weight;
    public int lNode;
    public int rNode;

    public HTNode(int weight) {
        this.weight = weight;
    }
}
