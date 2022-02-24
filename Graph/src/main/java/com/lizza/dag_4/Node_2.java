package com.lizza.dag_4;

import com.lizza.Request;
import com.lizza.ResourceId;

import java.util.Optional;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public class Node_2 extends Node {

    @Override
    Object compute(Request request) {
        ResourceId node7 = ResourceId.builder().request(request).node("Node_7").build();
        Optional<Object> resource4 = fetchResource(node7, 700);
        int i7 = (int) resource4.orElse(0);
        handle(request);
        return request.getCount() * name() + i7;
    }

    @Override
    int name() {
        return 2;
    }


}
