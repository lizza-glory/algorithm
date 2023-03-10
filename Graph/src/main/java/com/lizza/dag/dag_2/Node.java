package com.lizza.dag.dag_2;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.lizza.mg.Request;
import com.lizza.mg.Result;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public abstract class Node {

    static final ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(3));

    List<Node> parents = Lists.newArrayList();

    abstract Result apply(Request request);
}
