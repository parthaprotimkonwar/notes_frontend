package com.notes.models.core;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.notes.application.enums.STATUS;
import com.notes.models.users.UserChapter;

import java.io.Serializable;
import java.util.List;


/**
 * Created by pkonwar on 4/9/2016.
 */
@Table(name = "CHAPTERS")
public class Chapter extends Model {

    public Chapter() {

    }

    public Chapter(Float price, String chapterName, Integer indexing, Subject subject, STATUS status) {
        this.price = price;
        this.chapterName = chapterName;
        this.indexing = indexing;
        this.subject = subject;
        this.status = status;
    }

    @Column(name = "CHAPTER_ID", notNull = true, unique = true)
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
}
