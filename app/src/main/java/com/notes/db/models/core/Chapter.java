package com.notes.db.models.core;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.notes.app.enums.STATUS;
import com.notes.db.models.users.UserChapter;

import java.util.List;


/**
 * Created by pkonwar on 4/9/2016.
 */
@Table(name = "CHAPTERS")
public class Chapter extends Model {

    public Chapter() {
    }

    public Chapter(Long chapterId, Float price, String chapterName, Integer indexing, Subject subject, STATUS status) {
        this.chapterId = chapterId;
        this.price = price;
        this.chapterName = chapterName;
        this.indexing = indexing;
        this.subject = subject;
        this.status = status;
    }

    @Column(name = "CHAPTER_ID", notNull = true, unique = true, index = true)
    private Long chapterId;

    @Column(name = "PRICE")
    private Float price;

    @Column(name = "CHAPTER_NAME")
    private String chapterName;

    @Column(name = "INDEXING")
    private Integer indexing;

    @Column(name = "STATUS")
    private STATUS status;

    //onDelete means : Action that takes place onDelete of Subject
    @Column(name = "SUBJECT", onDelete = Column.ForeignKeyAction.CASCADE)
    private Subject subject;

    private List<Module> moduleList;

    private List<UserChapter> userChapterList;

    public List<Module> getModuleList() {
        return getMany(Module.class, "CHAPTER");
    }

    public List<UserChapter> getUserChapterList() {
        return getMany(UserChapter.class, "CHAPTER");
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Integer getIndexing() {
        return indexing;
    }

    public void setIndexing(Integer indexing) {
        this.indexing = indexing;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
