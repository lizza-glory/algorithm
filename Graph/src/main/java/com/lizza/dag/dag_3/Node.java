package com.lizza.dag.dag_3;

import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.lizza.mg.Request;
import com.lizza.mg.Result;

import java.util.Set;
import java.util.concurrent.Executors;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public abstract class Node {

    static final ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(3));

    Set<Node> parents = Sets.newHashSet();

    Set<Node> children = Sets.newHashSet();

    abstract Result apply(Request request);

    abstract String name();

    @Override
    public String toString() {
        return name();
    }
}
