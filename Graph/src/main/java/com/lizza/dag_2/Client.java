package com.lizza.dag_2;

import com.google.common.base.Stopwatch;
import com.lizza.Request;
import com.lizza.Result;

import java.util.concurrent.TimeUnit;

/**
 * 1    2
 *  \  /
 *   3
 *   |
 *   4
 * 1. 顶点并行执行, 理论总耗时: 耗时最长的链路, 900ms
 * 2. 缺陷: 公共资源无法保证只加载一次, 如下图, 6 是 3 和 4 的公共资源, 从下往上加载, 可能会被 3 和 4 加载两次
 * 5   6    7
 *  \ / \ / |
 *   3   4  |
 *    \ / \ |
 *     1    2
 */
public class Client {

    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Node node = new Node_1();
        Result result = node.apply(new Request(10));
        System.out.println(result.getCount());
        System.out.println("cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
