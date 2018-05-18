package com.codingapi.sds.delivery.ato.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lorne
 */
public class ResModel {

    private List<ModelNode> nodes;

    private int total;

    public ResModel() {
        nodes = new ArrayList<>();
    }

    public List<ModelNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<ModelNode> nodes) {
        this.nodes = nodes;
    }

    public int getTotal() {
        int allSize = 0;
        for (ModelNode node : nodes) {
            allSize += node.getSize();
        }
        return allSize;
    }
}
