package com.lizza.web.service;

import com.google.common.graph.ImmutableGraph;
import com.lizza.web.dto.Context;
import com.lizza.web.dto.Node;
import com.lizza.web.dto.Request;
import com.lizza.web.enums.GraphEnum;
import org.springframework.stereotype.Service;

@Service
public class FactorD extends AbstractFactor{

    @Override
    GraphEnum key() {
        return GraphEnum.FACTOR_D;
    }

    @Override
    public void compute(Request request, Context context) {
        ImmutableGraph<Node> graph = request.getGraph();
        // 检查所有父节点是否都完成了
        if (!checkPredecessorsIsCompleted(graph)) {
            return;
        }
        handle(request, context);
    }
}
