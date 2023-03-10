package com.lizza.dag.dag_3;

import com.lizza.mg.Request;
import com.lizza.mg.Result;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public class Node_1 extends Node {

    {
        parents.add(new Node_3());
        parents.add(new Node_4());
    }

    @Override
    Result apply(Request request) {
        return null;
    }

    @Override
    String name() {
        return "Node_1";
    }
}
