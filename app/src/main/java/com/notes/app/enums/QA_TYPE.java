package com.notes.app.enums;

/**
 * Created by pkonwar on 4/9/2016.
 */
public enum QA_TYPE {

    /**
     * SHORT : Short Answer
     * LONG : Long Answer
     * MULTI : Multi Choices
     */
    SHORT("SHORT"), LONG("LONG"), MULTI("MULTI");

    private String type = null;

    QA_TYPE(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
