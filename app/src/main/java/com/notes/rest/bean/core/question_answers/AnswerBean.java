package com.notes.rest.bean.core.question_answers;

import com.google.gson.annotations.Expose;

/**
 * Created by pkonwar on 4/9/2016.
 */

public class AnswerBean {

    public AnswerBean(Long answerId) {
        this.answerId = answerId;
    }

    public AnswerBean(String answer) {
        this.answer = answer;
    }

    @Expose
    private Long answerId;
    @Expose
    private String answer;

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
