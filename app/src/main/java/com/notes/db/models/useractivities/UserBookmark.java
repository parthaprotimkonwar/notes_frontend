package com.notes.db.models.useractivities;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.notes.app.enums.STATUS;
import com.notes.db.models.core.question_answers.ModuleQuestionAnswer;
import com.notes.db.models.users.User;

import java.util.Date;

/**
 * Created by pkonwar on 5/26/2016.
 */

@Table(name = "USER_BOOKMARKS")
public class UserBookmark extends Model{

    @Column(name = "USER_ID")
    private User userId;

    @Column(name = "MODULE_QUESTION_ANSWER_ID", unique = true)
    private ModuleQuestionAnswer moduleQuestionAnswer;

    @Column(name = "DATE_TIME")
    private Date dateTime;

    @Column(name = "STATUS")
    private STATUS status;

    public UserBookmark() {}

    public UserBookmark(User userId, ModuleQuestionAnswer moduleQuestionAnswer, Date dateTime, STATUS status) {
        this.userId = userId;
        this.moduleQuestionAnswer = moduleQuestionAnswer;
        this.dateTime = dateTime;
        this.status = status;
    }


    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public ModuleQuestionAnswer getModuleQuestionAnswer() {
        return moduleQuestionAnswer;
    }

    public void setModuleQuestionAnswer(ModuleQuestionAnswer moduleQuestionAnswer) {
        this.moduleQuestionAnswer = moduleQuestionAnswer;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }
}
