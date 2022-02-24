package com.lizza.dag_4;

import com.lizza.Request;
import com.lizza.ResourceId;

import java.util.Optional;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public class Node_1 extends Node {

    @Override
    Object compute(Request request) {
        ResourceId node3 = ResourceId.builder().request(request).node("Node_3").build();
        ResourceId node4 = ResourceId.builder().request(request).node("Node_4").build();
        Optional<Object> resource3 = fetchResource(node3, 1200);
        Optional<Object> resource4 = fetchResource(node4, 1200);
        int i3 = (int) resource3.orElse(0);
        int i4 = (int) resource4.orElse(0);
        handle(request);
        return request.getCount() * name() + i3 + i4;
    }

    @Override
    int name() {
        return 1;
    }
}
