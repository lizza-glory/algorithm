package com.lizza.dag_3;

import com.lizza.Request;
import com.lizza.Result;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public class Node_3 extends Node {

    {
        parents.add(new Node_5());
        parents.add(new Node_6());
    }

    @Override
    Result apply(Request request) {
        return null;
    }

    @Override
    String name() {
        return "Node_3";
    }
}
