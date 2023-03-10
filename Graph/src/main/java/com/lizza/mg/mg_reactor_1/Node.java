package com.lizza.mg.mg_reactor_1;

import com.google.common.base.Stopwatch;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import com.lizza.web.utils.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 业务场景: 每个节点计算得到当前节点的耗时, 任一节点的耗时为节点编号与 SLEEP_RATIO 的乘积, 单位是秒
 * 例如: 节点一, 本身耗时就是 100ms
 * <p>
 * 1. 要解决的问题: 资源重复加载
 * 2. 方式: 资源从上往下进行加载
 * <p>
 * 5   6    7
 * \ / \ / |
 * 3   4  |
 * \ / \ |
 * 1    2
 */
public abstract class Node {

    int value;

    /**
     * 当前节点是否完成
     **/
    AtomicBoolean isCompleted = new AtomicBoolean(false);

    static Stopwatch stopwatch = Stopwatch.createStarted();

    static ExecutorService executorService = Executors.newFixedThreadPool(10);

    /**
     * 节点值
     */
    abstract int value();

    /**
     * 获取当前节点
     */
    Node currentNode() {
        return this;
    }

    /**
     * 检查当前节点的所有父节点是否完成
     *
     * @param graph       图对象
     * @param currentNode 当前节点
     * @return true: 表示完成了, false: 表示没有完成
     */
    boolean checkPredecessorsIsCompleted(MutableGraph<Node> graph, Node currentNode) {
        return graph.predecessors(currentNode).stream()
                    .allMatch(e -> e.isCompleted.get());
    }

    /**
     * 业务逻辑处理/计算
     *
     * @param request 请求参数
     * @param context 单次请求的上下文数据
     */
    abstract void handle(Request request, Context context);

    /**
     * 处理所有子节点的业务
     * @param request
     * @param context
     */
    void handleSuccessors(Request request, Context context) {
        context.getGraph()
               .successors(currentNode())
               .forEach(e -> e.handle(request, context));
    }

    void doHandle(Request request, Context context) {
        try {
            // 线程睡眠模拟业务处理耗时
            TimeUnit.SECONDS.sleep(value);
            // 计算耗时
            context.setValue(context.getValue() + value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Logger.info("Node: {}, Value: {}, Cost: {}",
                    currentNode().getClass().getSimpleName(),
                    value, stopwatch.elapsed(TimeUnit.MILLISECONDS));
        }
    }

    /**
     * 打印当前节点及父子节点
     */
    public void printGraph(MutableGraph<Node> graph) {
        for (Node e : graph.nodes()) {
            System.out.println(e + ": predecessors: "
                    + graph.predecessors(e) + ", successors: "
                    + graph.successors(e) + ", inDegree: "
                    + graph.inDegree(e) + ", outDegree: "
                    + graph.outDegree(e));
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    /**
     * 5   6    7
     * \ / \ / |
     * 3   4  |
     * \ / \ |
     * 1    2
     */
    public static void main(String[] args) {
        MutableGraph<Node> graph = GraphBuilder.directed().allowsSelfLoops(false).build();

        Node node_1 = new Node_1(1);
        Node node_2 = new Node_2(2);
        Node node_3 = new Node_3(3);
        Node node_4 = new Node_4(4);
        Node node_5 = new Node_5(5);
        Node node_6 = new Node_6(6);
        Node node_7 = new Node_7(7);
        graph.putEdge(node_5, node_3);
        graph.putEdge(node_6, node_3);
        graph.putEdge(node_6, node_4);
        graph.putEdge(node_7, node_4);
        graph.putEdge(node_7, node_2);
        graph.putEdge(node_3, node_1);
        graph.putEdge(node_4, node_1);
        graph.putEdge(node_4, node_2);

        Context context = new Context();
        Request request = new Request();
        context.setGraph(graph);

        // 获取所有节点
        graph.nodes().stream()
             // 获取所有根节点(入度为 0)
             .filter(item -> graph.inDegree(item) == 0)
             // 从根节点开始执行
             .forEach(root -> {
                 root.handle(request, context);
             });
    }
}
