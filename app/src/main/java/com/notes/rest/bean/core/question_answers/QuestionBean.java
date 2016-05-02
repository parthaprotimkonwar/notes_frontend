package com.notes.rest.bean.core.question_answers;

import com.google.gson.annotations.Expose;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class QuestionBean {

    public QuestionBean(Long questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }

    @Expose
    private Long questionId;
    @Expose
    private String question;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
