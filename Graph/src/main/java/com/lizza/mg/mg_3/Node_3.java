package com.lizza.mg.mg_3;

import com.lizza.mg.Context;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public class Node_3 extends Node {

    @Override
    int compute(Context context, int request) {
        handle();
        int result = request * weight();
        context.setResult(getClass().getSimpleName(), result);
        return result;
    }

    @Override
    int weight() {
        return 3;
    }

    @Override
    void onSuccess(Context context, int request) {
        for (Node child : children) {
            executorService.execute(() -> {
                child.compute(context, request);
            });
        }
    }
}
