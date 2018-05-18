package com.codingapi.sds.delivery.ato.vo;

/**
 * @author lorne
 */
public class ModelNode {

    private String model;

    private int size;

    public ModelNode(String model, int size) {
        this.model = model;
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
