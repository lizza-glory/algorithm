package com.lizza.dag.dag_1;

import com.google.common.base.Stopwatch;
import com.lizza.mg.Request;
import com.lizza.mg.Result;

import java.util.concurrent.TimeUnit;

/**
 * 1    2
 *  \  /
 *   3
 *   |
 *   4
 * 1. 所有节点串行执行, 理论总耗时: 1000ms
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Node node = new Node_1();
        Result result = node.apply(new Request(10));
        System.out.println(result.getCount());
        System.out.println("cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
