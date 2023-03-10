package com.lizza.dag.dag_4;

import com.lizza.mg.Request;
import com.lizza.mg.ResourceId;

import java.util.Optional;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public class Node_8 extends Node {

    @Override
    Object compute(Request request) {
        ResourceId node9 = ResourceId.builder().request(request).node("Node_9").build();
        ResourceId node10 = ResourceId.builder().request(request).node("Node_10").build();
        timeWatch();
        Optional<Object> resource9 = fetchResource(node9, 2100);
        timeWatch();
        Optional<Object> resource10 = fetchResource(node10, 2100);
        timeWatch();
        int i9 = (int) resource9.orElse(0);
        int i10 = (int) resource10.orElse(0);
        handle(request);
        return request.getCount() * name() + i10 + i9;
    }

    @Override
    int name() {
        return 8;
    }
}
