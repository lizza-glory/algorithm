package com.lizza.mg_reactor_1;

import com.google.common.graph.MutableGraph;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

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
        Flux.just(handle(graph, request, context))
                // 使用自定义的线程池
                .publishOn(Schedulers.fromExecutorService(executorService))
                // 设置超时
                .timeout(Duration.ofNanos(1000))
                .subscribe(value -> {
                    // 将当前节点的状态改为已完成
                    isCompleted.compareAndSet(false, true);
                    handleSuccessors(graph, request, context, value);
                });
    }

    @Override
    int value() {
        return 1;
    }
}
