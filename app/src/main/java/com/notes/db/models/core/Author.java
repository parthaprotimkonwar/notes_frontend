package com.notes.db.models.core;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Table(name = "AUTHORS")
public class Author extends Model {

    public Author() {
    }

    public Author(Long authorId, String authorName, String authorDescription) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorDescription = authorDescription;
    }

    @Column(name = "AUTHOR_ID", index = true, unique = true)
    private Long authorId;

    @Column(name = "AUTHOR_NAME", notNull = true)
    private String authorName;

    @Column(name = "AUTHOR_DESCRIPTION")
    private String authorDescription;

    private List<SubjectAuthor> subjectAuthorList;

    public List<SubjectAuthor> getSubjectAuthorList() {
        return getMany(SubjectAuthor.class, "AUTHOR");
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    public void setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
    }
}
