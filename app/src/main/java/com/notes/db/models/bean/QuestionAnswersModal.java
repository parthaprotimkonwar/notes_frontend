package com.notes.db.models.bean;

import com.notes.app.enums.QA_TYPE;
import com.notes.db.models.useractivities.UserBookmark;
import com.notes.db.models.useractivities.UserComment;

import java.util.List;

/**
 * Created by pkonwar on 5/5/2016.
 */
public class QuestionAnswersModal {

    private Long moduleGetId;
    private Long questionAnswerGetId;
    private String question;
    private String answer;
    private QA_TYPE questionType;
    private Options options;
    private UserBookmark bookmark;
    private List<UserComment> userComments;

    public QuestionAnswersModal(Long moduleGetId, Long questionAnswerGetId, String question, String answer, QA_TYPE questionType, Options options,
                                UserBookmark bookmark, List<UserComment> userComments) {
        this.moduleGetId = moduleGetId;
        this.questionAnswerGetId = questionAnswerGetId;
        this.question = question;
        this.answer = answer;
        this.questionType = questionType;
        this.options = options;
        this.bookmark = bookmark;
        this.userComments = userComments;
    }

    public UserBookmark getBookmark() {
        return bookmark;
    }

    public void setBookmark(UserBookmark bookmark) {
        this.bookmark = bookmark;
    }

    public List<UserComment> getUserComments() {
        return userComments;
    }

    public void setUserComments(List<UserComment> userComments) {
        this.userComments = userComments;
    }

    public Long getModuleGetId() {
        return moduleGetId;
    }

    public void setModuleGetId(Long moduleGetId) {
        this.moduleGetId = moduleGetId;
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

    public Long getQuestionAnswerGetId() {
        return questionAnswerGetId;
    }

    public void setQuestionAnswerGetId(Long questionAnswerGetId) {
        this.questionAnswerGetId = questionAnswerGetId;
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
