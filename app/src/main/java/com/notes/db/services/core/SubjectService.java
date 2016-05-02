package com.notes.db.services.core;

import com.activeandroid.query.Select;
import com.notes.db.models.core.Subject;

/**
 * Created by pkonwar on 5/2/2016.
 */
public class SubjectService {

    /**
     * Find a Subject from the Database based on @param subjectId
     * @param subjectId
     * @return
     */
    public static Subject findASubject(Long subjectId) {
        return new Select().from(Subject.class).where("SUBJECT_ID = ?", subjectId).executeSingle();
    }

}
