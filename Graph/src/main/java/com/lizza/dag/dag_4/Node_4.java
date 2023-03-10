package com.lizza.dag.dag_4;

import com.lizza.mg.Request;
import com.lizza.mg.ResourceId;

import java.util.Optional;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public class Node_4 extends Node {

    @Override
    Object compute(Request request) {
        ResourceId node6 = ResourceId.builder().request(request).node("Node_6").build();
        ResourceId node7 = ResourceId.builder().request(request).node("Node_7").build();
        Optional<Object> resource6 = fetchResource(node6, 700);
        Optional<Object> resource7 = fetchResource(node7, 700);
        int i6 = (int) resource6.orElse(0);
        int i7 = (int) resource7.orElse(0);
        handle(request);
        return request.getCount() * name() + i7 + i6;
    }

    @Override
    int name() {
        return 4;
    }
}
