package com.notes.ui.activity.bean;

import java.io.Serializable;

/**
 * Created by pkonwar on 5/5/2016.
 */
public class DataBundle implements Serializable {

    private DataBundle() {
    }

    private Long subjectId;
    private Long chapterId;

    private static DataBundle dataBundle = new DataBundle();

    public static DataBundle getInstance() {
        return dataBundle;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }
}
