package com.notes.db.models.core.question_answers;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.notes.app.enums.QA_TYPE;

import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Table(name = "QUESTIONS_ANSWERS")
public class QuestionAnswer extends Model {

    public QuestionAnswer() {}

    public QuestionAnswer(Long questionAnswerId, Question question, Answer answer, QA_TYPE type) {
        this.questionAnswerId = questionAnswerId;
        this.question = question;
        this.answer = answer;
        this.type = type;
    }

    @Column(name = "QUESTION_ANSWER_ID", unique = true, notNull = true, index = true)
    private Long questionAnswerId;

    @Column(name = "QUESTION")
    private Question question;

    @Column(name = "ANSWER")
    private Answer answer;

    @Column(name = "TYPE")
    private QA_TYPE type;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
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
