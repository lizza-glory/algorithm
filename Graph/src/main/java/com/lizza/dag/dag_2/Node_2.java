package com.lizza.dag.dag_2;

import com.google.common.collect.Lists;
import com.lizza.mg.Request;
import com.lizza.mg.Result;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public class Node_2 extends Node {

    {
        parents.add(new Node_3());
        parents.add(new Node_4());
        parents.add(new Node_5());
    }

    @Override
    Result apply(Request request) {
        Result result = new Result(request.getCount() * 2);
        List<CompletableFuture<Result>> futureList = Lists.newArrayList();
        for (Node node : parents) {
            futureList.add(CompletableFuture.supplyAsync(() -> node.apply(request), executorService));
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[futureList.size()]));
        for (CompletableFuture<Result> future : futureList) {
            try {
                result.setCount(result.getCount() + future.get().getCount());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            // 处理当前节点逻辑
            System.out.println("Node_2 do something...");
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
