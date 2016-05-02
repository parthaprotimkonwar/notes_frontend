package com.notes.db.models.core;

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

    public SubjectAuthor(Subject subject, Author author) {
        this.subject = subject;
        this.author = author;
    }

    @Column(name = "SUBJECT", onDelete = Column.ForeignKeyAction.CASCADE)
    private Subject subject;

    @Column(name = "AUTHOR", onDelete = Column.ForeignKeyAction.CASCADE)
    private Author author;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
