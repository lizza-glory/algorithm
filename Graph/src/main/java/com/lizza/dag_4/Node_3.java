package com.lizza.dag_4;

import com.lizza.Request;
import com.lizza.ResourceId;

import java.util.Optional;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public class Node_3 extends Node {

    @Override
    Object compute(Request request) {
        ResourceId node5 = ResourceId.builder().request(request).node("Node_5").build();
        ResourceId node6 = ResourceId.builder().request(request).node("Node_6").build();
        Optional<Object> resource5 = fetchResource(node5, 600);
        Optional<Object> resource6 = fetchResource(node6, 600);
        int i5 = (int) resource5.orElse(0);
        int i6 = (int) resource6.orElse(0);
        handle(request);
        return request.getCount() * name() + i5 + i6;
    }

    @Override
    int name() {
        return 3;
    }
}
