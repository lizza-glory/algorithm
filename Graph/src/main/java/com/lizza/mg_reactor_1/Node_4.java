package com.lizza.mg_reactor_1;

import com.google.common.graph.MutableGraph;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-07
 */
public class Node_4 extends Node {

    @Override
    void compute(Request request, Context context) {
        MutableGraph<Node> graph = context.getGraph();
        if (!checkComplete(graph)) {
            return;
        }
        Flux.just(handle(graph, request, context))
                // 使用自定义的线程池
                .publishOn(Schedulers.fromExecutorService(executorService))
                // 设置超时
//                .timeout(Duration.ofNanos(1000))
                .subscribe(value -> {
                    // 将当前节点的状态改为已完成
                    isCompleted.compareAndSet(false, true);
                    handleSuccessors(graph, request, context, value);
                });
    }


    @Override
    int value() {
        return 4;
    }
}
