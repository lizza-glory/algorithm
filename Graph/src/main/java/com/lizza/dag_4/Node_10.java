package com.lizza.dag_4;

import com.lizza.Request;
import com.lizza.ResourceId;

import java.util.Optional;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public class Node_10 extends Node {

    @Override
    Object compute(Request request) {
        ResourceId node11 = ResourceId.builder().request(request).node("Node_11").build();
        Optional<Object> resource11 = fetchResource(node11, 1100);
        int i11 = (int) resource11.orElse(0);
        handle(request);
        return request.getCount() * name() + i11;
    }

    @Override
    int name() {
        return 10;
    }
}
