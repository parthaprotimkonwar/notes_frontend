package com.notes.db.services.core;

import com.activeandroid.query.Select;
import com.notes.db.models.core.Author;
import com.notes.db.models.core.SubjectAuthor;

/**
 * Created by pkonwar on 5/2/2016.
 */
public class SubjectAuthorService {

    public static SubjectAuthor findASubjectAuthor(Long subjectId, Long authorId) {
        return new Select().from(SubjectAuthor.class).where("SUBJECT_AUTHOR.SUBJECT = ?", subjectId).and("SUBJECT_AUTHOR.AUTHOR = ?", authorId).executeSingle();
    }
}
