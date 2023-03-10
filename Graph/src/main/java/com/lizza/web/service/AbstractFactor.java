package com.lizza.web.service;

import com.google.common.base.Stopwatch;
import com.google.common.graph.ImmutableGraph;
import com.lizza.web.dto.Context;
import com.lizza.web.dto.Node;
import com.lizza.web.dto.Request;
import com.lizza.web.enums.GraphEnum;
import com.lizza.web.utils.Logger;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class AbstractFactor {

    static ExecutorService executorService = Executors.newFixedThreadPool(10);

    abstract GraphEnum key();

    /**
     * 业务逻辑处理/计算
     *
     * @param request 请求参数
     * @param context 上下文数据
     */
    public abstract void compute(Request request, Context context);

    /**
     * 检查当前节点的所有父节点是否完成
     * @param graph       图对象
     * @return true: 表示完成了, false: 表示没有完成
     */
    boolean checkPredecessorsIsCompleted(ImmutableGraph<Node> graph) {
        return graph.predecessors(getCurrentNode(graph)).stream()
                .filter(Objects::nonNull)
                .allMatch(e -> e.getCompleted().get());
    }

    /**
     * 获取当前节点
     * @param graph
     * @return
     */
    Node getCurrentNode(ImmutableGraph<Node> graph) {
        return graph.nodes().stream()
                .filter(e -> Objects.nonNull(e.getFactor()) && Objects.equals(e.getFactor().key(), key()))
                .findAny().orElseThrow(() -> new RuntimeException("Node not found, key: " + key()));
    }

    void handle(Request request, Context context) {

        // 获取本次请求节点结构图
        ImmutableGraph<Node> graph = request.getGraph();

        Flux.just(request)
                // 使用自定义的线程池
                .publishOn(Schedulers.fromExecutorService(executorService))
                .timeout(Duration.ofSeconds(60))
                .subscribe(req -> {
                    // 处理当前节点业务
                    doHandle(request, context);
                    // 将当前节点的状态改为已完成
                    getCurrentNode(graph).getCompleted().compareAndSet(false, true);
                    // 处理子节点的任务
                    handleSuccessors(request, context);
                });
    }

    /**
     * 实际业务处理
     * @param request
     * @param context
     */
    void doHandle(Request request, Context context) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        ImmutableGraph<Node> graph = request.getGraph();
        int value = getCurrentNode(graph).getValue();
        try {
            // 模拟业务逻辑执行的耗时
            TimeUnit.SECONDS.sleep(value);

            // 填充结果
            context.getResult().getAndAdd(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Logger.info("Node: {}, Request Value: {}, Cost: {}, Result Value: {}",
                    getCurrentNode(graph).getFactor().key(),
                    value, stopwatch.elapsed(TimeUnit.MILLISECONDS),
                    context.getResult().get());
        }
    }

    /**
     * 处理所有子节点的业务
     * @param request
     * @param context
     */
    void handleSuccessors(Request request, Context context) {
        ImmutableGraph<Node> graph = request.getGraph();
        graph.successors(getCurrentNode(graph))
                .forEach(e -> e.getFactor().compute(request, context));
    }
}
