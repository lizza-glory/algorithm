package com.lizza.web.enums;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.ImmutableGraph;
import com.google.common.graph.MutableGraph;
import com.lizza.web.dto.Node;
import com.lizza.web.service.*;
import com.lizza.web.utils.SpringUtil;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * graph 枚举: 主要维护因子的依赖关系
 * todo 扩展: 图结构界面化维护, 需要定义简单的数据结构来存储(DB), 然后解析出来, 构建 graph 对象
 *
 * A    B
 *  \ / |
 *   C  D
 */
public enum GraphEnum {

    FACTOR_A(){
        @Override
        ImmutableGraph<Node> build() {
            MutableGraph<Node> graph = GraphBuilder.directed().allowsSelfLoops(false).build();
            graph.addNode(Node.builder().factor(SpringUtil.getBean(FactorA.class)).completed(new AtomicBoolean(false)).value(1).build());
            return ImmutableGraph.copyOf(graph);
        }
    },
    FACTOR_B(){
        @Override
        ImmutableGraph<Node> build() {
            MutableGraph<Node> graph = GraphBuilder.directed().allowsSelfLoops(false).build();
            graph.addNode(Node.builder().factor(SpringUtil.getBean(FactorB.class)).completed(new AtomicBoolean(false)).value(2).build());
            return ImmutableGraph.copyOf(graph);
        }
    },
    FACTOR_C(){
        @Override
        ImmutableGraph<Node> build() {
            System.out.println("build...");
            MutableGraph<Node> graph = GraphBuilder.directed().allowsSelfLoops(false).build();
            graph.putEdge(Node.builder().factor(SpringUtil.getBean(FactorA.class)).value(1).completed(new AtomicBoolean(false)).build(), Node.builder().factor(SpringUtil.getBean(FactorC.class)).value(3).completed(new AtomicBoolean(false)).build());
            graph.putEdge(Node.builder().factor(SpringUtil.getBean(FactorB.class)).value(2).completed(new AtomicBoolean(false)).build(), Node.builder().factor(SpringUtil.getBean(FactorC.class)).value(3).completed(new AtomicBoolean(false)).build());
            return ImmutableGraph.copyOf(graph);
        }
    },
    FACTOR_D(){
        @Override
        ImmutableGraph<Node> build() {
            MutableGraph<Node> graph = GraphBuilder.directed().allowsSelfLoops(false).build();
            graph.putEdge(Node.builder().factor(SpringUtil.getBean(FactorB.class)).value(2).completed(new AtomicBoolean(false)).build(), Node.builder().factor(SpringUtil.getBean(FactorD.class)).value(4).completed(new AtomicBoolean(false)).build());
            return ImmutableGraph.copyOf(graph);
        }
    },
    ;

    public static ImmutableGraph<Node> getGraph(GraphEnum key) {
        return Arrays.stream(GraphEnum.values()).filter(e -> Objects.equals(key, e))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Graph is not found! key: " + key.name()))
                .build();
    }

    abstract ImmutableGraph<Node> build();
}
