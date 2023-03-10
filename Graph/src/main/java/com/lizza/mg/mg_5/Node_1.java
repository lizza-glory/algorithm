package com.lizza.mg.mg_5;

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
public class Node_1 extends Node {

    @Override
    void compute(Request request, Context context) {
        // 获取本次请求节点结构图
        MutableGraph<Node> graph = context.getGraph();
        // 检查所有父节点是否都完成了
        if (!checkComplete(graph)) {
            return;
        }
        ListenableFuture<Integer> future = executorService.submit(() ->
                handle(graph, request, context));
        Futures.addCallback(future, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(@Nullable Integer value) {
                // 将当前节点的状态改为已完成
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
        return 1;
    }
}
