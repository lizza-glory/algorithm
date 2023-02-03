package com.lizza.mg_reactor_1;

import com.google.common.graph.MutableGraph;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-07
 */
public class Node_4 extends Node {

    public Node_4(int value) {
        super.value = value;
    }

    @Override
    void handle(Request request, Context context) {

        // 获取本次请求节点结构图
        MutableGraph<Node> graph = context.getGraph();

        // 检查所有父节点是否都完成了
        if (!checkPredecessorsIsCompleted(graph, this)) {
            return;
        }

        Flux.just(request)
            // 使用自定义的线程池
            .publishOn(Schedulers.fromExecutorService(executorService))
            // 设置超时
            .timeout(Duration.ofSeconds(value))
            .subscribe(req -> {

                // 处理当前节点业务
                doHandle(request, context);

                // 将当前节点的状态改为已完成
                isCompleted.compareAndSet(false, true);

                // 处理子节点的任务
                handleSuccessors(request, context);
            });
    }

    @Override
    int value() {
        return value;
    }
}
