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

    @Column(name = "SUBJECT", onDelete = Column.ForeignKeyAction.CASCADE)
    private Subject subject;

    @Column(name = "AUTHOR", onDelete = Column.ForeignKeyAction.CASCADE)
    private Author author;

}
