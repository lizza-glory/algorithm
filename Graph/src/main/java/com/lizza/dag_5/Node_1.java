package com.lizza.dag_5;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.TimeUnit;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-07
 */
public class Node_1 extends Node {

    @Override
    void compute(Request request, Context context) {
        ListenableFuture<Integer> future = executorService.submit(() -> {
//            while (context.getValue("Node_2") != null && context.getValue("Node_3") != null) {
//                break;
//            }
            handle();
            return request.getCount() * value() + context.getValue("Node_2") + context.getValue("Node_3");
        });
        Futures.addCallback(future, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(@Nullable Integer value) {
                context.setValue("Node_1", value);
                System.out.println("Node_1: " + value + ", cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
            }

            @Override
            public void onFailure(Throwable t) {

            }
        }, executorService);
    }

    @Override
    int value() {
        return 1;
    }
}
