package com.notes.rest.bean.core.question_answers;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class QuestionsBean {

    public QuestionsBean(Long questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }

    private Long questionId;

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
