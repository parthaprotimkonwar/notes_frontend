package com.notes.models.core;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Table(name = "SUBJECT_AUTHOR")
public class SubjectAuthor extends Model {
    public SubjectAuthor() {
    }

    @Column(name = "SUBJECTID_AUTHORID", unique = true, notNull = true, index = true)
    private Long subjectIdAuthorId;

    @Column(name = "SUBJECT")
    private Subject subject;

    @Column(name = "AUTHOR")
    private Author author;
}
