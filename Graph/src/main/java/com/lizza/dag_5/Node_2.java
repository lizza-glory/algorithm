package com.lizza.dag_5;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-07
 */
public class Node_2 extends Node {

    @Override
    void compute(Request request, Context context) {
        ListenableFuture<Integer> future = executorService.submit(() -> {
            handle();
            return request.getCount() * value();
        });
        Futures.addCallback(future, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(@Nullable Integer value) {
                Node node = new Node_1();
                context.setValue("Node_2", value);
                node.compute(request, context);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        }, executorService);
    }


    @Override
    int value() {
        return 2;
    }
}
