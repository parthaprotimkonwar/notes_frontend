package com.notes.db.services.core.useractivities;

import com.activeandroid.query.Select;
import com.notes.app.enums.STATUS;
import com.notes.db.models.useractivities.UserComment;

import java.util.List;

/**
 * Created by pkonwar on 5/26/2016.
 */
public class UserCommentService {

    public static List<UserComment> comments(Long moduleQuestionAnswerId) {
        return new Select().from(UserComment.class).where("MODULE_QUESTION_ANSWER = ?", moduleQuestionAnswerId).execute();
    }

    public static List<UserComment> commentsWithStatus(Long moduleQuestionAnswerId, STATUS status) {
        return new Select().from(UserComment.class).where("MODULE_QUESTION_ANSWER = ?", moduleQuestionAnswerId).and("STATUS = ?", status).execute();
    }
}
