package com.notes.db.models.core;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.notes.app.enums.STATUS;

import java.util.List;

/**
 * Created by pkonwar on 4/23/2016.
 */
@Table(name = "SUBJECTS")
public class Subject extends Model {

    public Subject() {
    }

    public Subject(Long subjectId, String subjectName, Float price, byte[] imageBlob, STATUS status) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.price = price;
        this.imageBlob = imageBlob;
        this.status = status;
    }

    @Column(name = "SUBJECT_ID", unique = true, notNull = true)
    private Long subjectId;

    @Column(name = "SUBJECT_NAME")
    private String subjectName;

    @Column(name = "PRICE")
    private Float price;

    @Column(name = "IMAGE_BLOB")
    private byte[] imageBlob;

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


    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public byte[] getImageBlob() {
        return imageBlob;
    }

    public void setImageBlob(byte[] imageBlob) {
        this.imageBlob = imageBlob;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }
}
