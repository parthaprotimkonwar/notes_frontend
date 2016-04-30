package com.notes.models.core.question_answers;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.notes.app.enums.QA_TYPE;

import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Table(name = "QUESTION_ANSWER")
public class QuestionsAnswer implements Serializable {

    public QuestionsAnswer() {}

    public QuestionsAnswer(Question question, Answer answer, QA_TYPE type) {
        this.question = question;
        this.answer = answer;
        this.type = type;
    }

    @Column(name = "QUESTION")
    private Question question;

    @Column(name = "ANSWER")
    private Answer answer;

    @Column(name = "TYPE")
    private QA_TYPE type;

}
