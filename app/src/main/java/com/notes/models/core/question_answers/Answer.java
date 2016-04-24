package com.notes.models.core.question_answers;

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

    public Answer(String answer) {
        this.answer = answer;
    }

    @Column(name = "ANSWER_ID", unique = true, notNull = true)
    private Long answerId;

    @Column(name = "ANSWER", notNull = true)
    private String answer;

}