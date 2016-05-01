package com.notes.rest.bean.core;

import com.google.gson.annotations.Expose;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class SubjectAuthorBean {

    public SubjectAuthorBean(){}

    public SubjectAuthorBean(Long subjectId, Long authorId){
        this.subjectId = subjectId;
        this.authorId = authorId;
    }

    @Expose
    private Long subjectId;
    @Expose
    private Long authorId;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
}
