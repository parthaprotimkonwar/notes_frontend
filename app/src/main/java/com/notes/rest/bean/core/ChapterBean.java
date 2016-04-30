package com.notes.rest.bean.core;

import com.google.gson.annotations.Expose;
import com.notes.app.enums.STATUS;

import java.io.Serializable;


/**
 * Created by pkonwar on 4/9/2016.
 */
public class ChapterBean implements Serializable {


    public ChapterBean(Long chapterId, Float price, String chapterName, Integer indexing, Long subjectId, STATUS status) {
        this.chapterId = chapterId;
        this.price = price;
        this.chapterName = chapterName;
        this.indexing = indexing;
        this.subjectId = subjectId;
        this.status = status;
    }

    @Expose
    private Long chapterId;
    @Expose
    private Float price;
    @Expose
    private String chapterName;
    @Expose
    private Integer indexing;
    @Expose
    private Long subjectId;
    @Expose
    private STATUS status;

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

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
}
