package com.notes.models.core;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.notes.application.enums.STATUS;

import java.util.List;

/**
 * Created by pkonwar on 4/23/2016.
 */
@Table(name = "SUBJECTS")
public class Subject extends Model {

    public Subject() {
    }

    @Column(name = "SUBJECT_ID", unique = true, notNull = true)
    private Long subjectId;

    @Column(name = "SUBJECT_NAME")
    private String subjectName;

    @Column(name = "PRICE")
    private Float price;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "STATUS")
    private STATUS status;

    private List<Chapter> chapterList;

    private List<SubjectAuthor> subjectAuthorList;

    public List<Chapter> getChapterList() {
        return getMany(Chapter.class, "SUBJECT");
    }

    public List<SubjectAuthor> getSubjectAuthorList() {
        return getMany(SubjectAuthor.class, "SUBJECT");
    }
}
