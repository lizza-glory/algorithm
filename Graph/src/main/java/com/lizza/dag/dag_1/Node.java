package com.lizza.dag.dag_1;

import com.google.common.collect.Lists;
import com.lizza.mg.Request;
import com.lizza.mg.Result;

import java.util.List;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public abstract class Node {

    List<Node> parents = Lists.newArrayList();

    abstract Result apply(Request request) throws Exception;
}
