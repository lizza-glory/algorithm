package com.lizza.dag.dag_4;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-07
 */
public class NodeHolder {

    public static Node getNode(String name) {
        switch (name) {
            case "Node_2":
                return new Node_2();
            case "Node_3":
                return new Node_3();
            case "Node_4":
                return new Node_4();
            case "Node_5":
                return new Node_5();
            case "Node_6":
                return new Node_6();
            case "Node_7":
                return new Node_7();
            case "Node_8":
                return new Node_8();
            case "Node_9":
                return new Node_9();
            case "Node_10":
                return new Node_10();
            case "Node_11":
                return new Node_11();
            default:
                return new Node_1();
        }
    }
}
