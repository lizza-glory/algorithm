package com.lizza.dag_4;

import com.lizza.Request;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public class Node_7 extends Node {

    @Override
    Object compute(Request request) {
        handle(request);
        return request.getCount() * name();
    }

    @Override
    int name() {
        return 7;
    }
}
