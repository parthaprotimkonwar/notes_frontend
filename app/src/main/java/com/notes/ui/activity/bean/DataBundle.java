package com.notes.ui.activity.bean;

import java.io.Serializable;

/**
 * Created by pkonwar on 5/5/2016.
 */
public class DataBundle implements Serializable{

    private Long subjectId;
    private Long chapterId;


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
