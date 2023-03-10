package com.lizza.dag.dag_4;

import com.google.common.base.Stopwatch;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.lizza.mg.Request;
import com.lizza.mg.ResourceId;

import java.util.Optional;
import java.util.concurrent.*;

/**
 * 1. 要解决的问题: 资源重复加载
 * 2. 方式: 资源从上往下进行加载 todo
 * 5   6    7
 *  \ / \ / |
 *   3   4  |
 *    \ / \ |
 *     1    2
 */
public abstract class Node {

    static Stopwatch stopwatch = Stopwatch.createStarted();

    static ExecutorService executorService = Executors.newFixedThreadPool(17);

    static LoadingCache<ResourceId, Object> cache = CacheBuilder.newBuilder()
            .expireAfterAccess(30, TimeUnit.DAYS)
            .maximumSize(64)
            .build(new CacheLoader<ResourceId, Object>() {
                @Override
                public Object load(ResourceId resourceId) {
                    Stopwatch stopwatch = Stopwatch.createStarted();
                    Node node = NodeHolder.getNode(resourceId.getNode());
                    Object result = node.compute(resourceId.getRequest());
//                    System.out.println(node.getClass().getSimpleName() + ", cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
                    return result;
                }
            });

    abstract Object compute(Request request);

    abstract int name();

    Optional<Object> fetchResource(ResourceId resourceId, long timeout) {
        CompletableFuture<Optional<Object>> future = CompletableFuture.supplyAsync(() -> {
            try {
                return Optional.ofNullable(cache.get(resourceId));
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return Optional.empty();
        }, executorService);
        try {
            return future.get(timeout, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\t Exception: " + resourceId.getNode().toString());
        }
        return Optional.empty();
    }

    void handle(Request request) {
        try {
            Thread.sleep(name() * 80);
//            timeWatch();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    void timeWatch() {
        System.out.println("\t" + this.getClass().getSimpleName() + " cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    public static void main(String[] args){
        Node node = new Node_8();
        Object result = node.compute(new Request(10));
        System.out.println("result: " + result + ", cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        executorService.shutdown();
    }
}
