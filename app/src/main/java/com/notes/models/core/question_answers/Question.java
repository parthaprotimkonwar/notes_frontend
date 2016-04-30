package com.notes.models.core.question_answers;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Table(name = "QUESTION")
public class Question extends Model {

    public Question() {
    }

    public Question(Long questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }

    @Column(name = "QUESTION_ID", unique = true, notNull = true)
    public Long questionId;

    @Column(name = "QUESTION", unique = true, notNull = true)
    public String question;

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
