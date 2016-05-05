package com.notes.db.models.ui;

import com.notes.app.enums.QA_TYPE;

/**
 * Created by pkonwar on 5/5/2016.
 */
public class QuestionAnswersModal {

    private Long questionAnswerId;
    private String question;
    private String answer;
    private QA_TYPE questionType;
    private Options options;

    public QuestionAnswersModal(Long questionAnswerId, String question, String answer, QA_TYPE questionType, Options options) {
        this.questionAnswerId = questionAnswerId;
        this.question = question;
        this.answer = answer;
        this.questionType = questionType;
        this.options = options;
    }

    static class Options{
        private String option1;
        private String option2;
        private String option3;
        private String option4;

        Options(String option1, String option2, String option3, String option4) {
            this.option1 = option1;
            this.option2 = option2;
            this.option3 = option3;
            this.option4 = option4;
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

    }

    public Long getQuestionAnswerId() {
        return questionAnswerId;
    }

    public void setQuestionAnswerId(Long questionAnswerId) {
        this.questionAnswerId = questionAnswerId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QA_TYPE getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QA_TYPE questionType) {
        this.questionType = questionType;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }
}
