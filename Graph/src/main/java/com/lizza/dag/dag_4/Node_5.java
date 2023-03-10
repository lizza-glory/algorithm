package com.lizza.dag.dag_4;

import com.lizza.mg.Request;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public class Node_5 extends Node {

    @Override
    Object compute(Request request) {
        handle(request);
        return request.getCount() * name();
    }

    @Override
    int name() {
        return 5;
    }
}
