package com.notes.rest.beans;

import com.google.gson.annotations.Expose;

/**
 * Created by pkonwar on 4/30/2016.
 */
public class QuestionBean{

    public QuestionBean() {
    }
    public QuestionBean(Long questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }

    @Expose
    public Long questionId;

    @Expose
    public String question;


}
