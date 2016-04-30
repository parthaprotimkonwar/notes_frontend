package com.notes.models.core.question_answers;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by pkonwar on 4/18/2016.
 */
@Table(name = "QUESTION_OPTIONS")
public class QuestionOptions extends Model{

    @Column(name = "QUESTION_OPTIONS_ID")
    private Long questionOptionsId;

    @Column(name = "QUESTION_ID")
    private Question question;

    @Column(name = "OPTION1", length = 25)
    private String option1;

    @Column(name = "OPTION2", length = 25)
    private String option2;

    @Column(name = "OPTION3", length = 25)
    private String option3;

    @Column(name = "OPTION4", length = 25)
    private String option4;

    @Column(name = "ADDITIONAL_OPTIONS", length = 25)
    private String additionalOptions;

    public QuestionOptions() {}

    public QuestionOptions(Question question, String option1, String option2, String option3, String option4) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

    public QuestionOptions(Question question, String option1, String option2, String option3, String option4, String additionalOptions) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.additionalOptions = additionalOptions;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAdditionalOptions() {
        return additionalOptions;
    }

    public void setAdditionalOptions(String additionalOptions) {
        this.additionalOptions = additionalOptions;
    }

    public Long getQuestionOptionsId() {
        return questionOptionsId;
    }

    public void setQuestionOptionsId(Long questionOptionsId) {
        this.questionOptionsId = questionOptionsId;
    }
}
