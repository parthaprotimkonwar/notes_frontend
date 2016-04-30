package com.notes.rest.bean.core.question_answers;

import com.google.gson.annotations.Expose;
import com.notes.app.enums.QA_TYPE;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class QuestionAnswerBean {

    public QuestionAnswerBean(Long questionId, Long answerId, QA_TYPE type) {
        this.questionId = questionId;
        this.answerId = answerId;
        this.type = type;
    }
    @Expose
    private Long questionAnswerId;
    @Expose
    private Long questionId;
    @Expose
    private Long answerId;
    @Expose
    private QA_TYPE type;


    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public QA_TYPE getType() {
        return type;
    }

    public void setType(QA_TYPE type) {
        this.type = type;
    }

    public Long getQuestionAnswerId() {
        return questionAnswerId;
    }

    public void setQuestionAnswerId(Long questionAnswerId) {
        this.questionAnswerId = questionAnswerId;
    }
}
