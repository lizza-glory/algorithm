package com.lizza.web.controller;

import com.google.common.graph.ImmutableGraph;
import com.lizza.web.dto.Context;
import com.lizza.web.dto.Node;
import com.lizza.web.dto.Request;
import com.lizza.web.enums.GraphEnum;
import com.lizza.web.utils.SpringUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping
public class BackdoorController {

    @GetMapping("hello")
    public String hello() {
        return "Hello, DAG!";
    }

    @GetMapping("springUtil")
    public String springUtil() {
        return SpringUtil.getBean("backdoorController", BackdoorController.class).hello();
    }

    @GetMapping("getGraph")
    public void getGraph() {
        ImmutableGraph<Node> graph1 = GraphEnum.getGraph(GraphEnum.FACTOR_C);
        ImmutableGraph<Node> graph2 = GraphEnum.getGraph(GraphEnum.FACTOR_C);
        System.out.println(graph1.equals(graph2));
    }

    @GetMapping("runDAG")
    public void runDAG() {
        ImmutableGraph<Node> graph1 = GraphEnum.getGraph(GraphEnum.FACTOR_C);
        graph1.nodes().stream()
                // 获取所有根节点(入度为 0)
                .filter(item -> graph1.inDegree(item) == 0)
                // 从根节点开始执行
                .forEach(e -> {
                    Request request = Request.builder().graph(graph1).build();
                    Context context = Context.builder().result(new AtomicInteger(0)).build();
                    e.getFactor().compute(request, context);
                });
    }
}
