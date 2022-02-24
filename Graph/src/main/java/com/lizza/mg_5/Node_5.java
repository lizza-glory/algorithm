package com.lizza.mg_5;

import com.google.common.graph.MutableGraph;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-07
 */
public class Node_5 extends Node {

    @Override
    void compute(Request request, Context context) {
        MutableGraph<Node> graph = context.getGraph();
        if (!checkComplete(graph)) {
            return;
        }
        ListenableFuture<Integer> future = executorService.submit(() ->
                handle(graph, request, context));
        Futures.addCallback(future, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(@Nullable Integer value) {
                isCompleted.compareAndSet(false, true);
                handleSuccessors(graph, request, context, value);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        }, executorService);
    }


    @Override
    int value() {
        return 5;
    }
}
