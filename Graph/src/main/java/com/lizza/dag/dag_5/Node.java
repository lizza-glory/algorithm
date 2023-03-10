package com.lizza.dag.dag_5;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Executors;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-07
 */
public abstract class Node {

    static Stopwatch stopwatch = Stopwatch.createStarted();

    static ListeningExecutorService executorService
            = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

    abstract void compute(Request request, Context context);

    abstract int value();

    void handle() {
        try {
            Thread.sleep(value() * 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Node node2 = new Node_2();
        Node node3 = new Node_3();
        Context context = new Context();
        Request request = new Request(10);
        node2.compute(request, context);
        node3.compute(request, context);
    }
}
