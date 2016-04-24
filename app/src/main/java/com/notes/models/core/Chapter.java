package com.notes.models.core;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.notes.application.enums.STATUS;

import java.io.Serializable;


/**
 * Created by pkonwar on 4/9/2016.
 */
@Table(name = "CHAPTERS")
public class Chapter implements Serializable {

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

    @Column(name = "SUBJECT")
    private Subject subject;

}
