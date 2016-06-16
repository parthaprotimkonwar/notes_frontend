package com.notes.db.services.core.useractivities;

import com.activeandroid.query.Select;
import com.notes.app.enums.STATUS;
import com.notes.db.models.useractivities.UserBookmark;

import java.util.List;

/**
 * Created by pkonwar on 5/26/2016.
 */
public class UserBookmarkService {

    public static List<UserBookmark> all() {
        return new Select().from(UserBookmark.class).execute();
    }

    public static UserBookmark getUserBookmark(Long moduleQuestionAnswerId) {
        return new Select().from(UserBookmark.class).where("MODULE_QUESTION_ANSWER_ID = ?", moduleQuestionAnswerId).executeSingle();
    }

    public static UserBookmark bookmarked(Long moduleQuestionAnswerId) {
        return new Select().from(UserBookmark.class).where("MODULE_QUESTION_ANSWER_ID = ?", moduleQuestionAnswerId).executeSingle();
    }

    public static UserBookmark bookmarkedWithStatus(Long moduleQuestionAnswerId, STATUS status) {
        return new Select().from(UserBookmark.class).where("MODULE_QUESTION_ANSWER_ID = ?", moduleQuestionAnswerId).and("STATUS = ?", status).executeSingle();
    }
}
