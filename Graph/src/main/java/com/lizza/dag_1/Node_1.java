package com.lizza.dag_1;

import com.lizza.Request;
import com.lizza.Result;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public class Node_1 extends Node{

    {
        parents.add(new Node_2());
    }

    @Override
    Result apply(Request request) throws Exception {
        Result result = new Result(request.getCount());
        for (Node node : parents) {
            try {
                Result applyResult = node.apply(request);
                result.setCount(result.getCount() + applyResult.getCount());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 处理当前节点逻辑
        System.out.println("Node_1 do something...");
        Thread.sleep(100);
        return result;
    }
}
