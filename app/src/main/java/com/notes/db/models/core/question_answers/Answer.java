package com.notes.db.models.core.question_answers;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by pkonwar on 4/9/2016.
 */

@Table(name = "ANSWER")
public class Answer extends Model {

    public Answer() {
    }

    public Answer(Long answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }

    @Column(name = "ANSWER_ID", unique = true, notNull = true)
    private Long answerId;

    @Column(name = "ANSWER", notNull = true)
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